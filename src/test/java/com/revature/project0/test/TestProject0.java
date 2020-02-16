package com.revature.project0.test;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.project0.core.*;

public class TestProject0 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/* ######### Account Class #########
	 * 
	 */
	@Test
	public void testAccountFields() {
		// Account fields: fName, lName, Address.
		String[] expected = {null,null,null};
		Account a = new Account();
		assertArrayEquals(expected, new String[] {a.firstName, a.lastName, a.address});
	}
	// ---------------------------------

	
	
	/* ######### Employee Class #########
	 * Extends Account
	 */
	@Test
	public void test() {
		fail("Not implemented");
	}
	// ---------------------------------
	
	

	/* ######### Customer Class #########
	 * 
	 */
	// ---------------------------------
	
	

	/* ######### Vehicle Class #########
	 * 
	 */
	// ---------------------------------
	
	

	/* ######### DealershipSystem Class #########
	 * Extends Account
	 */
	// ---------------------------------

	
	
	/* #########  Class #########
	 * 
	 */
	// ---------------------------------
	
	
	
	
}
