package com.nida.exception;

import java.util.List;

public class PharmacyNotFoundException extends RuntimeException{
	
	public PharmacyNotFoundException(int pharmaId) {
		super("Pharmacy with ID "+pharmaId+" not found");
	}
	
	public PharmacyNotFoundException(List<String> zipArray) {
		super("Checked in localities"+zipArray+"\nPharmacies not found");
	}

	
	public PharmacyNotFoundException(String name) {
		super("Pharmacy with name "+name+" not found");
	}
	
	public PharmacyNotFoundException() {
		super("There are no pharmacies here");
	}

}
