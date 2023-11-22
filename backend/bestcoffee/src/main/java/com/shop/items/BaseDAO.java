package com.shop.items;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseDAO { 
	/**
	 * Encapsulation to simplify non-DQL statements
	 * @param sql SQL statement with placeholders
	 * @param params Values for the placeholders; the values passed must match the positions of '?' in the SQL statement
	 * @return Number of affected rows after execution
	 * @throws Exception 
	 */
	public int excuteUpdate(String sql, Object... params) throws Exception {
		// get connection
		Connection connection = jdbcUtils.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// set placeholder
		// Variable arguments can be used as an array. Database indexing starts from 1, 
		// so it is necessary to iterate starting from 1.
		for (int i = 1; i <= params.length; i++) {
			preparedStatement.setObject(i, params[i - 1]);
		}
		
		int rows = preparedStatement.executeUpdate();
		
		preparedStatement.close();
		
		if (connection.getAutoCommit()) {
			jdbcUtils.freeConnection(connection);		
		}
		
		return rows;
	}
	
	/**
	 * Encapsulation method for non-DQL statements -> Return type is fixed as int.
	 * Encapsulation for DQL syntax statements -> Return type is generic List<T>.
	 * 
	 * <T> declares a generic, an undetermined type.
	 * 1. To determine the generic type, for example, User.class, T = User.
	 * 2. Reflection techniques are used for attribute assignment.
	 * public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params);
	 * @throws Exception
	 */
	
	@SuppressWarnings("deprecation")
	public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws Exception{
		// 获取链接
		Connection connection = jdbcUtils.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		if (params != null && params.length != 0) {
			for (int i = 1; i <= params.length; i++) {
				preparedStatement.setObject(i, params[i - 1]);
			}
		}
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		// store the result
		List<T> list = new ArrayList<>();
		
		// get column information
		ResultSetMetaData metaData = resultSet.getMetaData();
		
		int columnCount = metaData.getColumnCount();
		while (resultSet.next()) {
			T t = clazz.newInstance(); // invoke the no parameter constructor to instaniate object
			
			// start from 1
			for (int i = 1; i <= columnCount; i++) {
				
				// property
				Object valueObject = resultSet.getObject(i);
				// name of propery
				String propertyName = metaData.getColumnLabel(i);
				
				// Reflectively assign values to the object's properties.
				java.lang.reflect.Field field = clazz.getDeclaredField(propertyName);
				field.setAccessible(true); // Properties can be set, breaking the private modifier.

		        // issues : bigDecimal come from datebase decimal 
				// big Decimal can not automatically trans to double
		        if (valueObject != null) {
		            if (field.getType() == double.class || field.getType() == Double.class) {
		                field.set(t, ((BigDecimal) valueObject).doubleValue());
		            } else {
		                // rest situations
		                field.set(t, valueObject);
		            }
		        }
			}
			
			list.add(t);
		}
		
		// close resouces
		resultSet.close();
		preparedStatement.close();
		if (connection.getAutoCommit()) {
			jdbcUtils.freeConnection(connection);
		}
		
		return list;
	}
}