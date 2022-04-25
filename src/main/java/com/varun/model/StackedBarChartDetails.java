package com.varun.model;

import java.util.ArrayList;

public class StackedBarChartDetails {

public ArrayList<Integer> overall = new ArrayList<Integer>();
public ArrayList<Integer> reserves = new ArrayList<Integer>();
public ArrayList<Integer> substitutes = new ArrayList<Integer>();
public ArrayList<Integer> others = new ArrayList<Integer>();
public ArrayList<Integer> getOverall() {
	return overall;
}
public ArrayList<Integer> getReserves() {
	return reserves;
}
public ArrayList<Integer> getSubstitutes() {
	return substitutes;
}
public ArrayList<Integer> getOthers() {
	return others;
}

}
