package com.varun.model;

import java.util.ArrayList;

public class BarChartDetails {
	public ArrayList<String> xplot = new ArrayList<String>();
	public ArrayList<Long> yplot = new ArrayList<Long>();
    String[] barColours;
	public ArrayList<String> getXplot() {
		return xplot;
	}
	public ArrayList<Long> getYplot() {
		return yplot;
	}
	public String[] getBarColours() {
		return barColours;
	} 

}
