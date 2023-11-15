package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtils {
	private static Connection connection = null;
    private static final String URL = "jdbc:mysql:///coffeeshop";
    private static final String USER = "java_app";
    private static final String PASSWORD = "123456";
    
    static {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void initialization() throws Exception {
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static Connection getConnection() throws Exception {
		initialization();
		return connection;
	}
	
	public static void freeConnection(Connection connection) throws SQLException {
		connection.close();
	}
}
