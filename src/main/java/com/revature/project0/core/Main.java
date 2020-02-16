package com.revature.project0.core;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.revature.project0.dao.SerializationDAO;

public class Main {
	private static Logger log = Logger.getRootLogger();
	Account acct;
	static boolean exitProgram; //At almost any point, the user can exit the program.
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Scanner s = new Scanner(System.in);
		Menus menus = new Menus();
		while(!exitProgram) {
			System.out.print("Are you an Employee(e), Customer(c), Not a Member(n), or Quit(q): ");
			String accountType = s.nextLine();
			
			char ch = accountType.charAt(0);
			
			switch(ch) {
			case 'e' : menus.employeeMenu();
						break;
			case 'c' : menus.customerMenu();
						break;
			case 'n'  : menus.createAccount();
						break;
			default  : exitProgram=true;
			}
			exitProgram = true; // Avoid infinite loop atm
		}
		
	}

}
