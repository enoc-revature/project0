package com.revature.project0.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.project0.dao.SerializationDAO;

public  class DealershipSystem<T> {
	// DealershipSystem is simply a collection of methods.
	private static Logger log = Logger.getRootLogger();
	public final static String DIRECTORYNAME = "src\\main\\resources\\DAOFiles\\";
	public final static double INTEREST = 0.05;

	public static double calculatePayments(String principle, String duration){
		double p = Double.parseDouble(principle);
		double d = Double.parseDouble(duration);
		double totalInterest = d*DealershipSystem.INTEREST;
		double totalWithInterest = p*totalInterest;
		return totalWithInterest/d;
	}
	
	public static boolean checkEmployeeCredentials(String id, String pw) {
		SerializationDAO dao = new SerializationDAO();
		Employee emp = (Employee) dao.readSerial(id,'E');
		//log.debug("pw input: "+pw);
		//log.debug("pw file: " + emp.password);
		return pw.equals(emp.password);
	}

	public static boolean checkCustomerCredentials(String id, String pw) {
		SerializationDAO dao = new SerializationDAO();
		Customer cus = (Customer) dao.readSerial(id,'C');
		//log.debug("pw input: "+pw);
		//log.debug("pw file: " + emp.password);
		return pw.equals(cus.password);
	}
	
	public static void save(Object o) {
		log.debug("System static save(Object) called");
		SerializationDAO dao = new SerializationDAO();
		dao.writeSerial(o);
	}

	public static Employee getEmployee(String id) {
		log.debug("System static get(String) called");
		SerializationDAO dao = new SerializationDAO();
		return (Employee) dao.readSerial(id, 'E');
	}

	public static Customer getCustomer(String id) {
		log.debug("System static get(String) called");
		SerializationDAO dao = new SerializationDAO();
		return (Customer) dao.readSerial(id, 'C');
	}

	public static Vehicle getVehicle(String id) {
		log.debug("System static get(String) called");
		SerializationDAO dao = new SerializationDAO();
		return (Vehicle) dao.readSerial(id, 'V');
	}

	public static ArrayList<Vehicle> getVehicles(String[] idList) {
	//public static ArrayList<Object> get(String[] idList) {
		log.debug("System static viewVehicles(String[]) called");
		ArrayList<Vehicle> vList = new ArrayList<Vehicle>();
		/*
		ArrayList<Object> oList = new ArrayList<Object>();
		ArrayList<Employee> eList = new ArrayList<Employee>();
		ArrayList<Customer> cList = new ArrayList<Customer>();
		*/
		SerializationDAO dao = new SerializationDAO();
		

		/*
		if(idList[0].substring(1,1) == "E") {
			for(String id : idList) 
				eList.add((Employee) dao.readSerial(id));
			return eList;
		} else if(idList[0].substring(1,1) == "C"){
			for(String id : idList) 
				cList.add((Customer) dao.readSerial(id));
			return cList;
		} else if(idList[0].substring(1,1) == "V") {
			for(String id : idList) 
				vList.add((Vehicle) dao.readSerial(id));
			return vList;
		}
		*/
		for(String id : idList) 
			vList.add((Vehicle) dao.readSerial(id, 'V'));
		return vList;
	}
	
	

}
