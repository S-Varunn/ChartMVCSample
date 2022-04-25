package com.varun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import org.json.JSONObject;

import com.varun.controller.helpers.CreateDBConn;
import com.varun.controller.helpers.DatabaseQuerying;
import com.varun.model.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChartDirector extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String choice = req.getParameter("name");
		Connection conn = CreateDBConn.getConnection();
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		JSONObject result = new JSONObject();
		try {
			Class.forName("org.json.JSONObject");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(choice.equals("bar")) {
			BarChartDetails bcd = new BarChartDetails();
			DatabaseQuerying.setBarChartData(conn, bcd);
			result.put("xvalues",bcd.getXplot());
			result.put("yvalues", bcd.getYplot());
			result.put("barColours", bcd.getBarColours());
			
		}
		else if(choice.equals("groupedbar")) {
			GroupedBarChartDetails gbcd = new GroupedBarChartDetails();
			DatabaseQuerying.setGroupedChartData(conn, gbcd);
			result.put("teamname", gbcd.getTeamName());
			result.put("avgheight", gbcd.getAvgHeight());
			result.put("avgweight", gbcd.getAvgWeight());

		}
		else if(choice.equals("stackedbar")) {
			StackedBarChartDetails sbcd = new StackedBarChartDetails();
			DatabaseQuerying.setStackedChartData(conn, sbcd);
			result.put("overall",sbcd.getOverall());
			result.put("reserves", sbcd.getReserves());
			result.put("substitutes",sbcd.getSubstitutes());
			result.put("others", sbcd.getOthers());
		}
		out.print(result);
		out.flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
		
}
