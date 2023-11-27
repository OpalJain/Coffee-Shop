package com.tus.coffee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CoffeeShopDatabase {
    public static void main(String[] args) {
        Connection connection = null;
        try {
        	
            String url = "jdbc:mysql://localhost:3306/coffeeshop";
            String user = "root";
            String password = "123456";
            System.out.println("Database connection successful");

            connection = DriverManager.getConnection(url, user, password);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
