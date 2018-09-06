package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.util.Properties;

public class DatabaseConnection {
	
	/**
     * Create database connection using JDBC driver
     * @return returns connection Instance 
     */
    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            //register JDBC Driver
            Class.forName(Properties.DRIVER);
            String url = Properties.URL;
            String userName=Properties.USERNAME;
            String password=Properties.PASSWORD;
            //opens connection
            connection = DriverManager.getConnection(url, userName, password);
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            classNotFoundException.printStackTrace();
        } 
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

}
