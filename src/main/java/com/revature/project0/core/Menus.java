package com.revature.project0.core;

import java.util.Scanner;

public class Menus {
	Scanner s = new Scanner(System.in);

	public void employeeMenu() {
		System.out.println("What would you like to do?");
		System.out.print("A) Add a vehicle\nB) Remove a vehicle\nC)View vehicles in the lot.\n");
		String option = s.nextLine();
		switch(option.charAt(0)) {
		case 'A' : addVehicle();
					break;
		case 'B' : removeVehicle();
					break;
		case 'C' : viewVehicles();
					break;
		default : return;
		}
	}
	
	public void customerMenu() {
		System.out.print("");
		
	}

	public void createAccount() {
		System.out.print("Would you like to create an employee(e) or customer(c) account: ");
		String accountType = s.nextLine();
		
		char ch = accountType.charAt(0);
		switch(ch) {
		case 'e': createEmployee();
					break;
		case 'c': createCustomer();
					break;
		default: Main.exitProgram=true;
		}
		
	}
	
	public void createEmployee() {
		Employee emp = new Employee();

		// Get info from user
		System.out.print("First Name: ");
		emp.firstName = s.nextLine();
		System.out.print("Last Name: ");
		emp.lastName = s.nextLine();
		System.out.print("Address: ");
		emp.address = s.nextLine();
		System.out.print("Employee ID (8 digits): ");
		emp.id = s.nextLine();
		
		// Save info
		DealershipSystem.save(emp);
	}
	
	public void createCustomer() {
		Customer cus = new Customer();
		
		// Get info from user
		System.out.print("First Name: ");
		cus.firstName = s.nextLine();
		System.out.print("Last Name: ");
		cus.lastName = s.nextLine();
		System.out.print("Address: ");
		cus.address = s.nextLine();
		System.out.print("Employee ID (8 digits): ");
		cus.creditCard = s.nextLine();
		
		// Save info
		DealershipSystem.save(cus);
		
	}
	public void addVehicle() {
		Vehicle v = new Vehicle();
		
		// Get info from user
		System.out.print("Make: ");
		v.make = s.nextLine();
		
		System.out.print("Model: ");
		v.model = s.nextLine();
		
		System.out.print("Year: ");
		v.year = s.nextLine();
		
		System.out.print("Mileage: ");
		v.mileage = s.nextLine();
		
		System.out.print("Condition: ");
		v.condition = s.nextLine();
		
		System.out.print("VIN: ");
		v.vin = s.nextLine();
		
		// Save vehicle
		DealershipSystem.save(v);
	}

	public void  removeVehicle(String id) {

	}
		
	public void  viewVehicles() {

	}
		
}
