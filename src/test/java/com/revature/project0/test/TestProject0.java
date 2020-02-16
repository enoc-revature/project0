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
		String expectation = dir + "employee.dat";
		Employee e = new Employee();
		File file = new File(dir);
		SerializationDAO s = new SerializationDAO();
		s.writeSerial(e);
		
    	File[] folder = file.listFiles();
    	assertEquals(expectation, folder[0].toString());
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
