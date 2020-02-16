package com.revature.project0.core;

import java.io.Serializable;
import java.util.ArrayList;

// POJO
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String make;
	String model;
	String year;
	String mileage;
	String condition; // make enum later
	transient ArrayList<String> bid;
	transient ArrayList<String >offer;
	String vin;
	boolean pended;
}
