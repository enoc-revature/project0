package com.revature.project0.dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.project0.core.Customer;
import com.revature.project0.core.Employee;
import com.revature.project0.core.Vehicle;

public class SerializationDAO<T> {
	private static Logger log = Logger.getRootLogger();
	public void writeSerial(T t) {
		String fileName = "";

		Employee employee = null;
		Employee e2 = new Employee();
	
		Customer customer = null;
		Customer c2 = new Customer();

		Vehicle vehicle = null;
		Vehicle v2 = new Vehicle();

		if(t instanceof Employee) {
			fileName = "employee";
			employee = (Employee) t;
			e2 = employee;
		} else if(t instanceof Customer) {
			fileName = "customer";
			customer = (Customer) t;
			c2 = customer;
		} else if(t instanceof Vehicle) {
			fileName = "vehicle";
			vehicle = (Vehicle) t;
			v2 = vehicle;
		} else {
			System.out.println("ERROR: ILLEGAL CLASS. TERMINATING PROGRAM.");
			System.exit(-101);
		}
		log.info("writeSerial called");

		String locationName = "src\\main\\resources\\DAOFiles\\" + fileName + ".dat";
		System.out.println(locationName);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		log.info("Variables initialized");
		try {
			fos = new FileOutputStream(locationName);
			oos = new ObjectOutputStream(fos); // This does all the heavy-lifting of serialization
			//oos.writeObject(o);
			if(t instanceof Employee) {
				oos.writeObject(e2);
			} else if(t instanceof Customer) {
				oos.writeObject(c2);
			} else if(t instanceof Vehicle) {
				oos.writeObject(v2);
			}
			log.debug("file steams opened and written successfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("FileNotFoundException occurred");
			e.printStackTrace();
		} catch(IOException e) {
			log.error("IOException for opening stream and writing occurred");
			e.printStackTrace();
		} finally {
			log.debug("Finished File Output");
			try {
				fos.close();
				oos.close();
				log.debug("Finished closing file-out resources.");
			} catch(IOException e) {
				log.error("IOException up fos.close() occurred");
				e.printStackTrace();
			}
		}	
		log.info("writeSerial FINISHED");
	}
	
	public T readSerial(String id) {
		Employee employee = null;
		Customer customer = null;
		Vehicle vehicle = null;

		if(id!="employee" && id!="customer" && id!="vehicle") {
			System.out.println("ERROR: ILLEGAL CLASS. TERMINATING PROGRAM.");
			System.exit(-102);
		}
		
		String locationName = "src\\main\\resources\\DAOFiles\\" + id + ".dat";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object o = new Object();
		T t;
		try {
			log.debug("Started try 1");
			fis = new FileInputStream(locationName);
			ois = new ObjectInputStream(fis); // This does all the heavy-lifting of serialization
			if(id == "employee") {
				employee = (Employee) ois.readObject();
			} else if(id == "customer") {
				customer = (Customer) ois.readObject();
			} else if(id == "vehicle") {
				vehicle = (Vehicle) ois.readObject();
			}
			log.debug("Ended try 1");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
				log.debug("Finished closing file-out resources.");
			} catch(IOException e) {
				log.error("IOException up fos.close() occurred");
				e.printStackTrace();
			}
		}

		if(id == "employee") {
			return (T) employee;
		} else if(id == "customer") {
			return (T) customer;
		} else if(id == "vehicle") {
			return (T) vehicle;
		} else {
			System.out.println("ERROR: INCORRECT CLASS TYPE ON FILE. TERMINATING PROGRAM");
			System.exit(-103);
		}
		return null;
	}
}
