package com.varun.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class SingleLevelChart {
	private String type;
	private JSONArray columnDisplayLabels = new JSONArray();  
	private ArrayList<String> labels = new ArrayList<String>();
	private ArrayList<String> dataset = new ArrayList<String>();
	public JSONArray getColumnDisplayLabels() {
		return columnDisplayLabels;
	}
	public void setColumnDisplayLabels(JSONArray columnDisplayLabels) {
		this.columnDisplayLabels = columnDisplayLabels;
	}
	public ArrayList<String> getLabels() {
		return labels;
	}
	public ArrayList<String> getDataset() {
		return dataset;
	}
	public String getType() {
		return type;
	}
	public void setLabels(ArrayList<String> labels) {
		this.labels = labels;
	}
	public void setDataset(ArrayList<String> dataset) {
		this.dataset = dataset;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void writeTo(OutputStream out) throws IOException {
		JSONObject result = new JSONObject();
		result.put("type",this.getType());
		result.put("columnDisplayLabel", this.getColumnDisplayLabels());
		result.put("label",this.getLabels());
		result.put("dataSet", this.getDataset());
		out.write(result.toString().getBytes());
		out.flush();
	}
	
}
