package com.revature.project0.core;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.dao.SerializationDAO;

public  class DealershipSystem<T> {
	// DealershipSystem is simply a collection of methods.
	public static double calculatePayments(String vin){
		
		return 0.0;
	}
	
	/*
	public void writeSerial(List<T> inputList) {
		String filename = "";
		List<Employee> empList = new ArrayList<Employee>();
		List<Customer> custList = new ArrayList<Customer>();
		List<Vehicle> vList = new ArrayList<Vehicle>();
		if(inputList.get(0) instanceof Employee) {
			filename = "employee.dao";
			for(T t : inputList)
				empList.add((Employee) t);
			SerializationDAO.writeSerial(empList);
		} else if(inputList.get(0) instanceof Customer) {
			filename = "customer.dao";
			for(T t : inputList)
				custList.add((Customer) t);
			SerializationDAO.writeSerial(custList);
		} else if(inputList.get(0) instanceof Customer) {
		} else if(inputList.get(0) instanceof Vehicle) {
			filename = "vehicle.dao";
			for(T t : inputList)
				vList.add((Vehicle) t);
			SerializationDAO.writeSerial(vList);
		} else if(inputList.get(0) instanceof Customer) {
		}
		
		
	}
	
	public Object readSerial() {
		
		return new Object();
	}
	*/

}
