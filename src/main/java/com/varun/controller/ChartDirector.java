package com.varun.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.varun.controller.helpers.CreateDBConn;
import com.varun.controller.helpers.DatabaseQuerying;
import com.varun.model.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChartDirector extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String[] singleLevelCharts = {"bar","pie","line","doughnut","polar","exploded","histogram"};
	private String[] multiLevelCharts = {"nestedDoughnut","stackedBar","groupedBar","multiLine","radar"};
	private String[] twoAxisCharts = {"scatter"};
	private String[] threeAxisCharts = {"bubble"};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = CreateDBConn.getConnection();
		URL url = new URL(req.getRequestURL().toString());
		String[] filePaths = url.getFile().split("/",10);
		String propertyFileName = filePaths[filePaths.length-1].split("\\.")[0];
		File configFile = new File("resources\\"+propertyFileName+".json");
//		File configFile = new File("C:\\Users\\Varun\\OneDrive\\Desktop\\Chart\\ChartMVC\\resources\\"+propertyFileName+".json");
        JSONTokener configDataToken = new JSONTokener(new FileInputStream(configFile));
        JSONObject userConfigData = new JSONObject(configDataToken);
		
		String type = userConfigData.getString("type");
		String query = userConfigData.getString("query");
		String labelMarker = userConfigData.getString("label_marker");
		JSONArray columnDisplayLabels = userConfigData.getJSONArray("column_display_labels");

		resp.setContentType("application/json");
		OutputStream out = resp.getOutputStream();
		
		if(Arrays.asList(singleLevelCharts).contains(type)) {
			SingleLevelChart singleLevel = new SingleLevelChart();
			JSONArray columnSchema = userConfigData.getJSONArray("column_schema");
			singleLevel.setType(type);
			singleLevel.setLabels(DatabaseQuerying.getColumnValues(conn, query,labelMarker));
			singleLevel.setDataset(DatabaseQuerying.getColumnValues(conn, query,columnSchema.getJSONObject(1).getString("alias")));
			singleLevel.setColumnDisplayLabels(columnDisplayLabels);
			singleLevel.writeTo(out);
		}
		else if(Arrays.asList(multiLevelCharts).contains(type)) {
			MultiLevelChart multiLevel = new MultiLevelChart();
			JSONArray columnSchema = userConfigData.getJSONArray("column_schema");
			multiLevel.setType(type);
			multiLevel.setLabels(DatabaseQuerying.getColumnValues(conn,query,labelMarker));
			for(int i=1;i<columnSchema.length();i++) {
				JSONObject currentColumn = columnSchema.getJSONObject(i);
				multiLevel.setDataset(currentColumn.getString("display_name"),DatabaseQuerying.getColumnValues(conn, query, currentColumn.getString("alias")));
			}
			multiLevel.setColumnDisplayLabels(columnDisplayLabels);
			multiLevel.writeTo(out);
		}
		else if(Arrays.asList(twoAxisCharts).contains(type)) {
			TwoAxisPlotChart twoAxis = new TwoAxisPlotChart();
			JSONArray xPlotColumns = userConfigData.getJSONArray("x_plot_columns");
			JSONArray yPlotColumns = userConfigData.getJSONArray("y_plot_columns");
			twoAxis.setType(type);
			twoAxis.setLabels(DatabaseQuerying.getColumnValues(conn, query, labelMarker));
			twoAxis.setXyPlotLabels(userConfigData.getJSONArray("plot_labels"));
			for(Object colName:xPlotColumns) {
				twoAxis.setXplots(DatabaseQuerying.getColumnValues(conn, query,(String)colName));
			}
			for(Object colName:yPlotColumns) {
				twoAxis.setYplots(DatabaseQuerying.getColumnValues(conn, query, (String) colName));
			}
			twoAxis.setColumnDisplayLabels(columnDisplayLabels);
			twoAxis.writeTo(out);
			
		}
		else if(Arrays.asList(threeAxisCharts).contains(type)) {
			ThreeAxisPlotChart threeAxis = new ThreeAxisPlotChart();
			JSONArray xPlotColumns = userConfigData.getJSONArray("x_plot_columns");
			JSONArray yPlotColumns = userConfigData.getJSONArray("y_plot_columns");
			JSONArray zPlotColumns = userConfigData.getJSONArray("z_plot_columns");
			threeAxis.setType(type);
			threeAxis.setLabels(DatabaseQuerying.getColumnValues(conn, query, labelMarker));
			threeAxis.setXyzPlotLabels(userConfigData.getJSONArray("plot_labels"));
			for(Object colName:xPlotColumns) {
				threeAxis.setXplots(DatabaseQuerying.getColumnValues(conn, query,(String)colName));
			}
			for(Object colName:yPlotColumns) {
				threeAxis.setYplots(DatabaseQuerying.getColumnValues(conn, query, (String) colName));
			}
			for(Object colName:zPlotColumns) {
				threeAxis.setZplots(DatabaseQuerying.getColumnValues(conn, query, (String) colName));
			}
			threeAxis.setColumnDisplayLabels(columnDisplayLabels);
			threeAxis.writeTo(out);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
		
}
