package com.varun.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ThreeAxisPlotChart {
	private String type;
	private JSONArray columnDisplayLabels = new JSONArray();
	private ArrayList<String> labels = new ArrayList<String>();
	private JSONArray xyzLabels = new JSONArray();
	private ArrayList<ArrayList<String>> xplots = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> yplots = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> zplots = new ArrayList<ArrayList<String>>();
	public String getType() {
		return type;
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
	public ArrayList<ArrayList<String>> getZplots() {
		return zplots;
	}
	public JSONArray getXyzLabels() {
		return xyzLabels;
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
	public void setZplots(ArrayList<String> zplots) {
		this.zplots.add(zplots);
	}
	public void setXyzPlotLabels(JSONArray xyzLabels) {
		this.setXyzLabels(xyzLabels);
	}
	public void setXyzLabels(JSONArray xyzLabels) {
		this.xyzLabels = xyzLabels;
	}
	public void setColumnDisplayLabels(JSONArray columnDisplayLabels) {
		this.columnDisplayLabels = columnDisplayLabels;
		
	}
	public JSONArray getColumnDisplayLabels() {
		return this.columnDisplayLabels;
	}
	public void writeTo(OutputStream out) throws IOException {
		JSONObject result = new JSONObject();
		result.put("type",this.getType());
		result.put("columnDisplayLabel",this.getColumnDisplayLabels());
		result.put("label",this.getLabels());
		result.put("xyzPlotLabels", this.getXyzLabels());
		result.put("xPlotData", this.getXplots());
		result.put("yPlotData", this.getYplots());
		result.put("zPlotData", this.getZplots());
		out.write(result.toString().getBytes());
		out.flush();
		
	}
	
}
