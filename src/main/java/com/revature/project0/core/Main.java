package com.revature.project0.core;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {
	private static Logger log = Logger.getRootLogger();
	Account acct;
	static boolean exitProgram; //At almost any point, the user can exit the program.
	public static void main(String[] args) {
		BasicConfigurator.configure();
		while(!exitProgram) {
			// Do stuff
			
			exitProgram = true; // Avoid infinite loop atm
		}
	}
}
