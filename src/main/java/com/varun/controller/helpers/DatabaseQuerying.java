package com.varun.controller.helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.varun.model.*;

public class DatabaseQuerying {
	public static void setBarChartData(Connection conn,BarChartDetails bcd) {
		String query = "SELECT club, SUM(value_eur) AS totalValue FROM fifa_player GROUP BY club LIMIT 20";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(query);
			while(result.next()) {
				bcd.xplot.add(result.getString(1));
				bcd.yplot.add(result.getLong(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void setGroupedChartData(Connection conn,GroupedBarChartDetails gbcd) {
		String query = "SELECT club, ROUND(AVG(height_cm),2) as avgheight , ROUND(AVG(weight_kg),2) as avgweight FROM fifa_player GROUP BY club LIMIT 20";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(query);
			while(result.next()) {
				gbcd.teamName.add(result.getString(1));
				gbcd.avgHeight.add(result.getDouble(2));
				gbcd.avgWeight.add(result.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void setStackedChartData(Connection conn, StackedBarChartDetails sbcd) {
		String query = "SELECT overall,COUNT(CASE team_position WHEN 'RES' THEN 1 ELSE NULL END ) AS RES,COUNT(CASE team_position WHEN 'SUB' THEN 1 ELSE NULL END) AS SUB, COUNT(CASE WHEN (team_position !='SUB' AND team_position !='RES') THEN 1 ELSE NULL END) AS other ,COUNT(team_position) AS total FROM fifa_player WHERE overall<=55 GROUP BY overall ORDER BY overall";
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(query);
			while(result.next()) {
				sbcd.overall.add(result.getInt(1));
				sbcd.reserves.add(result.getInt(2));
				sbcd.substitutes.add(result.getInt(3));
				sbcd.others.add(result.getInt(4));			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
