package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseDAO { 
	/**
	 * 封装简化非DQL语句
	 * @param sql 带占位符的SQL语句
	 * @param params 占位符的值 传入的值必须等于？的位置
	 * @return 执行影响的行数
	 * @throws Exception 
	 */
	public int excuteUpdate(String sql, Object... params) throws Exception {
		// 获取链接
		Connection connection = jdbcUtils.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// 5. 占位符赋值
		// 可变参数可以当作数组使用 数据库索引从1开始，因此这个需要从1 开始做循环
		for (int i = 1; i <= params.length; i++) {
			preparedStatement.setObject(i, params[i - 1]);
		}
		
		int rows = preparedStatement.executeUpdate();
		
		preparedStatement.close();
		
		// 是否回收链接需要考虑是不是事务
		// 如何判断：通常如果开启事务，会触发这个语句 connection.setAutoCommit(false)
		// 如果已经开启类事务，就不要管，交给业务层处理
		if (connection.getAutoCommit()) {
			// 没有开启事务
			// 正常回收
			jdbcUtils.freeConnection(connection);		
		}
		
		return rows;
	}
	
	/**
	 * 非DQL语句封装方法 -> 返回值 固定为int
	 * DQL 语法语句封装 -> 返回值 范型 List<T>
	 * 	
	 * <T> 声明一个范型，不确定类型
	 * 1. 确定泛型 User.class T = User
	 * 2. 要使用反射技术属性赋值
	 * public <T> List<T> executeQuery(Class<T> clazz,String sql, Object... params);
	 * @throws Exception 
	 */
	
	@SuppressWarnings("deprecation")
	public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws Exception{
		// 获取链接
		Connection connection = jdbcUtils.getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		// 占位符赋值
		if (params != null && params.length != 0) {
			for (int i = 1; i <= params.length; i++) {
				preparedStatement.setObject(i, params[i - 1]);
			}
		}
		
		// 发送SQL 语句
		ResultSet resultSet = preparedStatement.executeQuery();
		
		// 结果分析
		List<T> list = new ArrayList<>();
		
		// 获取列的信息
		ResultSetMetaData metaData = resultSet.getMetaData();
		
		int columnCount = metaData.getColumnCount();
		while (resultSet.next()) {
			T t = clazz.newInstance(); // 调用类的无参构造函数实例化对象！
			
			// 自动遍历，注意要从1开始
			for (int i = 1; i <= columnCount; i++) {
				
				// 对象的属性值
				Object valueObject = resultSet.getObject(i);
				// 对象的属性名
				String propertyName = metaData.getColumnLabel(i);
				
				// 反射给对象的属性值
				java.lang.reflect.Field field = clazz.getDeclaredField(propertyName);
				field.setAccessible(true); // 属性可以设置， 打破private修饰
				/**
				 * 参数1: 要赋值的对象，如果属性是静态的，第一个参数可以为null
				 * 参数2: 具体的属性值
				 * 
				 */
				field.set(t, valueObject);
			}
			
			list.add(t);
		}
		
		// 关闭资源
		resultSet.close();
		preparedStatement.close();
		if (connection.getAutoCommit()) {
			jdbcUtils.freeConnection(connection);
		}
		
		return list;
	}
}