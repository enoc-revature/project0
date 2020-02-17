package com.revature.project0.core;

import java.io.Serializable;

// POJO
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String firstName;
	public String lastName;
	public String address;
	public transient String passWord;
	
}
