package com.revature.project0.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.project0.dao.SerializationDAO;

public  class DealershipSystem<T> {
	// DealershipSystem is simply a collection of methods.
	private static Logger log = Logger.getRootLogger();
	public static double calculatePayments(String vin){
		
		return 0.0;
	}
	
	public static void save(Object o) {
		log.debug("System static save(Object) called");
	}

	public static Object get(String id) {
		log.debug("System static get(String) called");
		return new Object();
	}

	public static Object get(String[] id) {
		log.debug("System static get(String[]) called");
		return new Object();
	}

}
