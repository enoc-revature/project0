package com.revature.project0.core;

import java.io.Serializable;
import java.util.ArrayList;

// POJO
public class Vehicle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String make;
	public String model;
	public String year;
	public String mileage;
	public String condition; // make enum later
	public transient ArrayList<String> bid;
	public transient ArrayList<String >offer;
	public String vin;
	public String owner = "Dealership";
	public transient String monthlyPayment;
	public boolean pended;
}
