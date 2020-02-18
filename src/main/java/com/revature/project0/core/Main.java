package com.revature.project0.core;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.revature.project0.dao.SerializationDAO;

public class Main {
	private static Logger log = Logger.getRootLogger();
	static Account acct;
	static boolean isEmployee;
	static boolean exitProgram; //At almost any point, the user can exit the program.
	public static void main(String[] args) {
		//String eclipseAbsolute = "C:\\Users\\enocs\\Downloads\\eclipse-jee-2019-12-R-win32-x86_64\\eclipse";
		//String log4jAbsolute = "C:\\Users\\enocs\\OneDrive\\Documents\\eclipse-workspace\\project0\\src\\main\\resources";
		//String relativePath = "../../OneDrive/Documents/eclipse-workspace/project0/src/main/resources/log4j.properties";
		//String relativePath = "..\\..\\OneDrive\\Documents\\eclipse-workspace\\project0\\src\\main\\resources\\log4j.properties";
		//PropertyConfigurator.configure(relativePath);
		//PropertyConfigurator.configure("src/main/resources/log4j.properties");
		//PropertyConfigurator.configure(".");
		//PropertyConfigurator.configure("C:\\Users\\enocs\\OneDrive\\Documents\\eclipse-workspace\\project0\\src\\main\\resources\\log4j.properties");
		//PropertyConfigurator.configure("C:/Users/enocs/OneDrive/Documents/eclipse-workspace/project0/src/main/resources/log4j.properties");
		//PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
		BasicConfigurator.configure();
		Scanner s = new Scanner(System.in);
		Menus menus = new Menus();
		while(!exitProgram) {
			System.out.print("Are you an Employee(e), Customer(c), Not a Member(n), or Quit(q): ");
			String accountType = s.nextLine();
			
			char ch = accountType.charAt(0);
			
			switch(ch) {
			case 'e' : acct = menus.employeeLogin();
						break;
			case 'c' : menus.customerLogin();
						break;
			case 'n'  : menus.createAccount();
						break;
			default  : exitProgram=true;
			}
			//exitProgram = true; // Avoid infinite loop atm
			
			if(acct != null) {
				menus.employeeMenu();
			} else {
				System.out.println("Incorrect login or password.\n\n");
			}
		}
		System.out.println("Have a nice day!");
		log.debug("Program terminated soundly.");
	}

}
