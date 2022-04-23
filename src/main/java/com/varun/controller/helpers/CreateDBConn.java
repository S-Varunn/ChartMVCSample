package com.varun.controller.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDBConn {
	public static Connection getConnection(){
		String jdbcUrl = "jdbc:postgresql://localhost:5432/sampleDatabase";
		String username="postgres";
		String password = "prochnost28";
		Connection conn = null;
		try {
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection(jdbcUrl,username,password);
		System.out.println("Connected to Database Successfully");
		} catch (SQLException e) {
			System.out.println("Not Connected,Some error");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
