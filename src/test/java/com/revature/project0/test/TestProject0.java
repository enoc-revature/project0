package com.revature.project0.test;


import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.project0.core.*;
import com.revature.project0.dao.SerializationDAO;

public class TestProject0 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BasicConfigurator.configure();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	/* #########  Serialization Class #########
	 * 
	 */
	@Test
	public void testCheckEmployeeWriteSerial() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		Scanner s = new Scanner(System.in);
		SerializationDAO dao = new SerializationDAO();

		Employee e = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "d";
		e.password = "pass";

		//String expectation = dir+ e.id + ".dat";
		String fileName = dir+ "_" + e.id + ".dat";
		File file = new File(fileName);
		if(file.exists()) // Kill file before dao writes it
			file.delete();
		s.nextInt(); // Check that file is not in folder
		dao.writeSerial(e);
    	//System.out.println(file.getPath());
    	//System.out.println(expectation);
    	//System.out.println(fileName);
    	assertEquals(fileName, file.getPath());
		s.nextInt(); // Check that file is in folder
		if(file.exists()) // Kill file because it's not part of the program
			file.delete();
	}

	@Test
	public void testCheckCustomerWriteSerial() {
		String dir = DealershipSystem.DIRECTORYNAME + "customers\\";
		Scanner s = new Scanner(System.in);
		SerializationDAO dao = new SerializationDAO();

		Customer c = new Customer();
		c.firstName = "a";
		c.lastName = "b";
		c.creditCard = "d";
		c.password = "pass";

		//String expectation = dir + c.creditCard + ".dat";
		String fileName = dir + "_" + c.creditCard + ".dat";
		File file = new File(fileName);
		if(file.exists()) // Kill file before dao writes it
			file.delete();
		s.nextInt(); // Check that file is not in folder
		dao.writeSerial(c);
    	//System.out.println(file.getPath());
    	//System.out.println(expectation);
    	assertEquals(fileName, file.getPath());
		s.nextInt(); // Check that file is in folder
		if(file.exists()) // Kill file because it's not part of the program
			file.delete();
	}

	@Test
	public void testCheckVehicleWriteSerial() {
		String dir = DealershipSystem.DIRECTORYNAME + "vehicles\\";
		Scanner s = new Scanner(System.in);
		SerializationDAO dao = new SerializationDAO();

		Vehicle v = new Vehicle();
		v.make = "a";
		v.model = "b";
		v.vin = "d123";
		v.principle = "123";

		//String expectation = dir+"_V_" + v.vin + ".dat";
		String fileName = dir+"_" + v.vin + ".dat";
		File file = new File(fileName);
		if(file.exists()) // Kill file before dao writes it
			file.delete();
		s.nextInt(); // Check that file is not in folder
		dao.writeSerial(v);
    	//System.out.println(file.getPath());
    	//System.out.println(expectation);
    	assertEquals(fileName, file.getPath());
		s.nextInt(); // Check that file is in folder
		if(file.exists()) // Kill file because it's not part of the program
			file.delete();
	}
	
	@Test
	public void testCheckEmployeeReadSerial_Without_Transient() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		Scanner s = new Scanner(System.in);
		SerializationDAO dao = new SerializationDAO();

		Employee e = new Employee();
		Employee eReturned = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "123";
		e.password = "pass";
		String[] expectation = {e.firstName, e.lastName};
		//System.out.println(e.firstName);
		//System.out.println(e.lastName);

		//String fileLocation = dir+"_E_" + e.id + ".dat";
		//String fileLocation = dir+ e.id + ".dat";
		//System.out.println(fileLocation);
		//File file = new File(fileLocation);
		dao.writeSerial(e);
		//System.out.println("###Before dao.readSerial");
		eReturned = (Employee) dao.readSerial(e.id, 'E');
		//System.out.println("###After dao.readSerial");
		//System.out.println(eReturned.firstName);
		//System.out.println(eReturned.lastName);
		String[] result = {eReturned.firstName, eReturned.lastName};

    	assertArrayEquals(expectation, result);
	}
	
	//@Test //Not finished
	public void testCheckEmployeeReadSerial_With_Transient() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		Scanner s = new Scanner(System.in);
		SerializationDAO dao = new SerializationDAO();

		Employee e = new Employee();
		Employee eReturned = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "_E_123";
		e.password = "pass";
		String[] expectation = {e.firstName, e.lastName, e.id, e.password};
		System.out.println(e.firstName);
		System.out.println(e.lastName);
		System.out.println(e.id);
		System.out.println(e.password);

		//String fileLocation = dir+"_E_" + e.id + ".dat";
		String fileLocation = dir+ e.id + ".dat";
		//System.out.println(fileLocation);
		//File file = new File(fileLocation);
		dao.writeSerial(e);
		//System.out.println("###Before dao.readSerial");
		eReturned = (Employee) dao.readSerial(e.id, 'E');
		//System.out.println("###After dao.readSerial");
		System.out.println(eReturned.firstName);
		System.out.println(eReturned.lastName);
		System.out.println(eReturned.id);
		System.out.println(eReturned.password);
		String[] result = {eReturned.firstName, eReturned.lastName, eReturned.id, eReturned.password};

    	assertArrayEquals(expectation, result);
	}

	@Test
	public void testCheckCustomerReadSerial_Without_Transient() {
		String dir = DealershipSystem.DIRECTORYNAME + "customers\\";
		Scanner s = new Scanner(System.in);
		SerializationDAO dao = new SerializationDAO();

		Customer c = new Customer();
		Customer cReturned = new Customer();
		c.firstName = "a";
		c.lastName = "b";
		c.creditCard = "123";
		String[] expectation = {c.firstName, c.lastName};
		//System.out.println(e.firstName);
		//System.out.println(e.lastName);

		//String fileLocation = dir+"_E_" + e.id + ".dat";
		String fileLocation = dir+ c.creditCard + ".dat";
		//System.out.println(fileLocation);
		//File file = new File(fileLocation);
		dao.writeSerial(c);
		//System.out.println("###Before dao.readSerial");
		cReturned = (Customer) dao.readSerial(c.creditCard, 'C');
		//System.out.println("###After dao.readSerial");
		//System.out.println(eReturned.firstName);
		//System.out.println(eReturned.lastName);
		String[] result = {cReturned.firstName, cReturned.lastName};

	   	assertArrayEquals(expectation, result);
	}

	@Test
	public void testCheckVehicleReadSerial_Without_Transient() {
		String dir = DealershipSystem.DIRECTORYNAME + "vehicles\\";
		Scanner s = new Scanner(System.in);
		SerializationDAO dao = new SerializationDAO();

		Vehicle v = new Vehicle();
		Vehicle vReturned = new Vehicle();
		v.make = "a";
		v.model = "b";
		v.vin = "123";
		String[] expectation = {v.make, v.model};
		//System.out.println(v.make);
		//System.out.println(v.model);

		//String fileLocation = dir+"_E_" + e.id + ".dat";
		String fileLocation = dir+ v.vin + ".dat";
		//System.out.println(fileLocation);
		//File file = new File(fileLocation);
		dao.writeSerial(v);
		//System.out.println("###Before dao.readSerial");
		vReturned = (Vehicle) dao.readSerial(v.vin, 'V');
		//System.out.println("###After dao.readSerial");
		//System.out.println(vReturned.firstName);
		//System.out.println(vReturned.lastName);
		String[] result = {vReturned.make, vReturned.model};

    	assertArrayEquals(expectation, result);
	}
	// ---------------------------------
	
			
	
	
	/* ######### DealershipSystem Class #########
	 * 
	 */
	@Test
	public void testDealershipEmployeeSave() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		Scanner s = new Scanner(System.in);

		Employee e = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "d";
		e.password = "pass";

		String expectation = dir+"_d.dat";
		String fileName = dir+"d.dat";
		File file = new File(expectation);
		if(file.exists()) // Kill file before dao writes it
			file.delete();
		//s.nextInt(); // Check that file is not in folder
		DealershipSystem.save(e);
    	//System.out.println(file.getPath());
    	//System.out.println(expectation);
    	//System.out.println(fileName);
    	assertEquals(expectation, file.getPath());
		//s.nextInt(); // Check that file is in folder
		if(file.exists()) // Kill file because it's not part of the program
			file.delete();
	}

	@Test
	public void testDealershipCustomerSave() {
		String dir = DealershipSystem.DIRECTORYNAME + "customers\\";
		Scanner s = new Scanner(System.in);

		Customer c = new Customer();
		c.firstName = "a";
		c.lastName = "b";
		c.creditCard = "d";
		c.password = "pass";

		String expectation = dir+"_d.dat";
		String fileName = dir+"d.dat";
		File file = new File(expectation);
		if(file.exists()) // Kill file before dao writes it
			file.delete();
		//s.nextInt(); // Check that file is not in folder
		DealershipSystem.save(c);
    	//System.out.println(file.getPath());
    	//System.out.println(expectation);
    	assertEquals(expectation, file.getPath());
		//s.nextInt(); // Check that file is in folder
		if(file.exists()) // Kill file because it's not part of the program
			file.delete();
	}

	@Test
	public void testDealershipVehicleSave() {
		Scanner s = new Scanner(System.in);
		String dir = DealershipSystem.DIRECTORYNAME + "vehicles\\";

		Vehicle v = new Vehicle();
		v.make = "a";
		v.model = "b";
		v.vin = "d123";
		v.principle = "123";
		
		String expectation = dir+"_d.dat";
		String fileName = dir+"d.dat";
		File file = new File(expectation);
		if(file.exists()) // Kill file before dao writes it
			file.delete();
		//s.nextInt(); // Check that file is not in folder
		DealershipSystem.save(v);
		//System.out.println(file.getPath());
		//System.out.println(expectation);
		assertEquals(expectation, file.getPath());
		//s.nextInt(); // Check that file is in folder
		if(file.exists()) // Kill file because it's not part of the program
			file.delete();
	}
	
	@Test
	public void DealershipGetEmployee() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		//Scanner s = new Scanner(System.in);

		Employee e = new Employee();
		Employee eReturned = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "123";
		String[] expectation = {e.firstName, e.lastName, e.id};
		//System.out.println(e.firstName);
		//System.out.println(e.lastName);
		//System.out.println(e.id);
		//System.out.println(e.password);

		//String fileLocation = dir+"_E_" + e.id + ".dat";
		String fileLocation = dir+ e.id + ".dat";
		//System.out.println(fileLocation);
		//File file = new File(fileLocation);
		DealershipSystem.save(e);
		//System.out.println("###Before dao.readSerial");
		eReturned = DealershipSystem.getEmployee(e.id);
		//System.out.println("###After dao.readSerial");
		//System.out.println(eReturned.firstName);
		//System.out.println(eReturned.lastName);
		//System.out.println(eReturned.id);
		//System.out.println(eReturned.password);
		String[] result = {eReturned.firstName, eReturned.lastName, eReturned.id};

    	assertArrayEquals(expectation, result);
	}

	@Test
	public void DealershipGetCustomer() {
		String dir = DealershipSystem.DIRECTORYNAME + "Customers\\";
		//Scanner s = new Scanner(System.in);

		Customer c = new Customer();
		Customer cReturned = new Customer();
		c.firstName = "a";
		c.lastName = "b";
		c.creditCard = "123";
		String[] expectation = {c.firstName, c.lastName, c.creditCard};
		//System.out.println(c.firstName);
		//System.out.println(c.lastName);
		//System.out.println(c.creditCard);
		//System.out.println(c.password);

		//String fileLocation = dir+"_E_" + c.creditCard + ".dat";
		String fileLocation = dir+ c.creditCard + ".dat";
		//System.out.println(fileLocation);
		//File file = new File(fileLocation);
		DealershipSystem.save(c);
		//System.out.println("###Before dao.readSerial");
		cReturned = DealershipSystem.getCustomer(c.creditCard);
		//System.out.println("###After dao.readSerial");
		//System.out.println(cReturned.firstName);
		//System.out.println(cReturned.lastName);
		//System.out.println(cReturned.creditCard);
		//System.out.println(cReturned.password);
		String[] result = {cReturned.firstName, cReturned.lastName, cReturned.creditCard};

    	assertArrayEquals(expectation, result);
	}

	@Test
	public void DealershipGetVehicle() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		//Scanner s = new Scanner(System.in);

		Vehicle v = new Vehicle();
		Vehicle vReturned = new Vehicle();
		v.make = "a";
		v.model = "b";
		v.vin = "123";
		String[] expectation = {v.make, v.model, v.vin};
		//System.out.println(e.firstName);
		//System.out.println(e.lastName);
		//System.out.println(e.id);
		//System.out.println(e.password);

		//String fileLocation = dir+"_E_" + e.id + ".dat";
		String fileLocation = dir+ v.vin + ".dat";
		//System.out.println(fileLocation);
		//File file = new File(fileLocation);
		DealershipSystem.save(v);
		//System.out.println("###Before dao.readSerial");
		vReturned = DealershipSystem.getVehicle(v.vin);
		//System.out.println("###After dao.readSerial");
		//System.out.println(eReturned.firstName);
		//System.out.println(eReturned.lastName);
		//System.out.println(eReturned.id);
		//System.out.println(eReturned.password);
		String[] result = {vReturned.make, vReturned.model, vReturned.vin};

    	assertArrayEquals(expectation, result);
	}
	
	@Test
	public void DealershipCheckEmployeeCredentialsTrue() {
		Employee e = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "123";
		e.password = "abc";

		DealershipSystem.save(e);
		
		assertEquals(true, DealershipSystem.checkEmployeeCredentials(e.id, e.password));
		
	}

	@Test
	public void DealershipCheckEmployeeCredentialsFalse() {
		Employee e = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "123";
		e.password = "abc";

		DealershipSystem.save(e);
		
		assertEquals(false, DealershipSystem.checkEmployeeCredentials(e.id, e.password+"N"));
		
	}

	@Test
	public void DealershipCheckCustomerCredentialsTrue() {
		Customer c = new Customer();
		c.firstName = "a";
		c.lastName = "b";
		c.creditCard = "123";
		c.password = "abc";

		DealershipSystem.save(c);
		
		assertEquals(true, DealershipSystem.checkEmployeeCredentials(c.creditCard, c.password));	
	}

	@Test
	public void DealershipCheckCustomerCredentialsFalse() {
		Customer c = new Customer();
		c.firstName = "a";
		c.lastName = "b";
		c.creditCard = "123";
		c.password = "abc";

		DealershipSystem.save(c);
		
		assertEquals(false, DealershipSystem.checkEmployeeCredentials(c.creditCard, c.password+"N"));	
	}

	
	//public static ArrayList<Vehicle> get(String[] idList) {
	//@Test // Not finished
	public void DealershipGetVehicles() {
		ArrayList<Vehicle> vList = new ArrayList<Vehicle>();
		ArrayList<Vehicle> vListReturned = new ArrayList<Vehicle>();
		ArrayList<Vehicle> listGetVehicles = new ArrayList<Vehicle>();
		Vehicle v1 = new Vehicle();
		v1.make = "a";
		v1.model = "b";
		v1.vin = "123";
		DealershipSystem.save(v1);
		String[] vFields1 = {v1.make, v1.model, v1.vin};

		/*
		Vehicle v2 = new Vehicle();
		v2.make = "c";
		v2.model = "d";
		v2.vin = "456";
		DealershipSystem.save(v2);
		String[] vFields2 = {v2.make, v2.model, v2.vin};
		*/
		vList.add(v1);
		//vList.add(v2);

		String[] idList = {"123"};
		
		SerializationDAO dao = new SerializationDAO();
		for(String id : idList) 
			vListReturned.add((Vehicle) dao.readSerial(id, 'V'));

		listGetVehicles = DealershipSystem.getVehicles(idList);

		//assertArrayEquals(vList, vListReturned);
		//assertArrayEquals(vList.get(0), );
	}
	// ---------------------------------


	
	/* ######### Account Class #########
	 * NO METHODS
	 */
	// ---------------------------------

	
	
	/* ######### Employee Class #########
	 * NO METHODS, Extends Account 
	 */
	// ---------------------------------
	
	

	/* ######### Customer Class #########
	 * NO METHODS, Extends Account
	 */
	// ---------------------------------
	
	

	/* ######### Vehicle Class #########
	 * NO METHODS
	 */
	// ---------------------------------
	
	
	
	/* #########  Main Class #########
	 * Menus return void
	 */
	// ---------------------------------
	

	
	/* #########  Menus Class #########
	 * Menus return void
	 */
	// ---------------------------------
}
