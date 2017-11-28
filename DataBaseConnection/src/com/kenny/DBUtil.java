package com.kenny;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	private static Connection connection;
	
	public DBUtil() {}
	
	public static synchronized Connection getConnection(){
		if (connection != null) {
			return connection;
		}
		else {
			try {
				String url = "jdbc:mysql://localhost:3306/mydatabase";
				String username = "root";
				String password = "1234";
				
				connection = DriverManager.getConnection(url, username, password);				
			} catch (SQLException e) {
			}
		}
		return connection;
	}
	
	public static synchronized void closedConnection() throws SQLException {
		if (connection != null) {
			try {
				connection.close();
			} finally {
				connection = null;
			}
		}
	}
}
