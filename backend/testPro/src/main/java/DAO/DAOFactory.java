package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

public class DAOFactory {

    private static final String URL = "your_database_url";
    private static final String USER = "your_database_user";
    private static final String PASSWORD = "your_database_password";

    private static DataSource dataSource;

    static {
        try {
			initializeDataSource();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private static void initializeDataSource() throws Exception {
		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql:///coffee", "java_app", "123456");
    }

    public static CartDAO getCartDAO() {
        return new CartDAO(dataSource);
    }

    public static MenuDAO getMenuDAO() {
        return new MenuDAO(dataSource);
    }
}
