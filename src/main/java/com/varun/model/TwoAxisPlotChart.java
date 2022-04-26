package com.varun.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class TwoAxisPlotChart {
	private String type;
	private JSONArray columnDisplayLabels = new JSONArray();
	private ArrayList<String> labels = new ArrayList<String>();
	private JSONArray xyPlotLabels = new JSONArray();
	private ArrayList<ArrayList<String>> xplots = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> yplots = new ArrayList<ArrayList<String>>();
	public String getType() {
		return type;
	}
	public JSONArray getColumnDisplayLabels() {
		return columnDisplayLabels;
	}
	public ArrayList<String> getLabels() {
		return labels;
	}
	public ArrayList<ArrayList<String>> getXplots() {
		return xplots;
	}
	public ArrayList<ArrayList<String>> getYplots() {
		return yplots;
	}
	public JSONArray getXyPlotLabels() {
		return this.xyPlotLabels;
	}
	
	public void setColumnDisplayLabels(JSONArray columnDisplayLabels) {
		this.columnDisplayLabels = columnDisplayLabels;
	}
	
	public void setXyPlotLabels(JSONArray xyPlotLabels) {
		this.xyPlotLabels = xyPlotLabels;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void setLabels(ArrayList<String> labels) {
		this.labels = labels;
	}
	
	public void setXplots(ArrayList<String> xplots) {
		this.xplots.add(xplots);
	}
	public void setYplots(ArrayList<String> yplots) {
		this.yplots.add(yplots);
	}
	public void writeTo(OutputStream out) throws IOException {
		JSONObject result = new JSONObject();
		result.put("type",this.getType());
		result.put("columnDisplayLabel",this.getColumnDisplayLabels());
		result.put("label",this.getLabels());
		result.put("xyPlotLabels", this.getXyPlotLabels());
		result.put("xPlotData", this.getXplots());
		result.put("yPlotData", this.getYplots());
		out.write(result.toString().getBytes());
		out.flush();
		
	}
	
	}
