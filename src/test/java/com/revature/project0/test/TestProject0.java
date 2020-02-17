package com.revature.project0.test;


import static org.junit.Assert.*;

import java.io.File;

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
	public void testCheckEmployeeSaveOneFile() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		SerializationDAO dao = new SerializationDAO();

		Employee e = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "d";
		e.passWord = "pass";
		dao.writeSerial(e);

		String expectation = "_E_d.dat";
		File folder = new File(dir);
    	String[] name = file.list();
    	String fileName = file.getPath()+file.getName();
    	//assertEquals(expectation, fileName);
    	//assertEquals(expectation, folder[0]);
    	assertEquals(expectation, name[1]);
	}

	@Test
	public void testCheckCustomerSaveOneFile() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		SerializationDAO dao = new SerializationDAO();

		Customer e = new Customer();
		e.firstName = "a";
		e.lastName = "b";
		//e.id = "d";
		e.passWord = "pass";
		dao.writeSerial(e);

		String expectation = dir + "_V_d.dat";
		File file = new File(dir);
    	String[] folder = file.list();
    	assertEquals(expectation, folder[0]);
	}

	@Test
	public void testCheckVehicleSaveOneFile() {
		String dir = DealershipSystem.DIRECTORYNAME + "employees\\";
		SerializationDAO dao = new SerializationDAO();

		Employee e = new Employee();
		e.firstName = "a";
		e.lastName = "b";
		e.id = "d";
		e.passWord = "pass";
		dao.writeSerial(e);

		String expectation = dir + "_V_d.dat";
		File file = new File(dir);
    	String[] folder = file.list();
    	assertEquals(expectation, folder[0]);
	}
	// ---------------------------------
	
			
	
	
	/* ######### DealershipSystem Class #########
	 * 
	 */
	@Test
	public void test1() {
		fail("Not yet implemented.");
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
