package com.varun.controller.helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseQuerying {
	public static ArrayList<String> getColumnValues(Connection conn, String query,String columnName) {
		Statement statement = null;
		ResultSet result = null;
		ArrayList<String> resultList = new ArrayList<String>();
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(query);
			while(result.next()) {
				resultList.add(result.getString(columnName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
		
	}
	
	
}
