package com.varun.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


public class MultiLevelChart {
	private String type;
	private JSONArray columnDisplayLabels = new JSONArray();
	private ArrayList<String> labels = new ArrayList<String>();
	private ArrayList<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();
	private ArrayList<String> dataSetLabels = new ArrayList<String>();
	
	public ArrayList<String> getLabels() {
		return labels;
	}
	public String getType() {
		return type;
	}
	public ArrayList<ArrayList<String>> getDataset() {
		return dataset;
	}
	
	public void setLabels(ArrayList<String> labels) {
		this.labels = labels;
	}
	
	public void setDataset(String subLabel,ArrayList<String> dataSet) {
		this.dataSetLabels.add(subLabel);
		this.dataset.add(dataSet);
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setColumnDisplayLabels(JSONArray columnDisplayLabels) {
		this.columnDisplayLabels = columnDisplayLabels;	
	}
	public ArrayList<String> getDataSetLabels() {
		return dataSetLabels;
	}
	public void setDataSetLabels(ArrayList<String> dataSetLabels) {
		this.dataSetLabels = dataSetLabels;
	}
	public JSONArray getColumnDisplayLabels() {
		return columnDisplayLabels;
	}
	public void setDataset(ArrayList<ArrayList<String>> dataset) {
		this.dataset = dataset;
	}
	public void writeTo(OutputStream out) throws IOException {
		JSONObject result = new JSONObject();
		result.put("type",this.getType());
		result.put("columnDisplayLabel",this.getColumnDisplayLabels());
		result.put("label",this.getLabels());
		result.put("dataSet", this.getDataset());
		result.put("dataSetLabels", this.getDataSetLabels());
		out.write(result.toString().getBytes());
		out.flush();
	}

	
	
} 
