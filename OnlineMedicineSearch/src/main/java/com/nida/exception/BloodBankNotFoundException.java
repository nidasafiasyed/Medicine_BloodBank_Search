package com.nida.exception;

import java.util.List;

public class BloodBankNotFoundException extends RuntimeException {

	public BloodBankNotFoundException() {
		// TODO Auto-generated constructor stub
		super("There are no blood banks here");
	}
	
	public BloodBankNotFoundException(int id) {
		// TODO Auto-generated constructor stub
		super("Blood bank with ID "+id+" not found");
	}
	
	public BloodBankNotFoundException(List<Integer> zipArray) {
		super("Checked in localities"+zipArray+"\nBlood banks not found");
	}

	
	public BloodBankNotFoundException(String name) {
		super("Blood bank with name "+name+" not found");
	}
	

	public BloodBankNotFoundException(String name, int zip) {
		// TODO Auto-generated constructor stub
		super("Blood bank with name "+name+" near "+zip+" not found");
	}

	public BloodBankNotFoundException(int id, int zipcode) {
		// TODO Auto-generated constructor stub
		super("Blood Bank "+id+" cannot be updated with invalid zipcode "+zipcode);
	}
	
	}
