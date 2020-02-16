package com.revature.project0.core;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.project0.dao.SerializationDAO;

public class Main {
	private static Logger log = Logger.getRootLogger();
	Account acct;
	static boolean exitProgram; //At almost any point, the user can exit the program.
	public static void main(String[] args) {
		BasicConfigurator.configure();
		while(!exitProgram) {
			// Do stuff
			SerializationDAO s = new SerializationDAO();
			Employee e = new Employee();
			//SerializationDAO.writeSerial(2);
			//System.out.println(SerializationDAO.readSerial("test"));
			//s.writeSerial(e);
			e = (Employee) s.readSerial("employee");
			System.out.println(e.firstName);
			System.out.println(e.lastName);
			System.out.println(e.address);
			
			
			exitProgram = true; // Avoid infinite loop atm
		}
	}
}
