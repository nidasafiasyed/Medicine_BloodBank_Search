package com.nida.exception;

public class BloodNotFoundException extends RuntimeException {
	
	public BloodNotFoundException(int bId) {
		// TODO Auto-generated constructor stub
		super("Blood with ID "+bId+" not found");
	}
	
	public BloodNotFoundException(String type) {
		// TODO Auto-generated constructor stub
		super("Blood with type "+type+" not found");
	}
	
	public BloodNotFoundException() {
		// TODO Auto-generated constructor stub
		super("There is no blood here");
	}

	public BloodNotFoundException(String type, int zip) {
		// TODO Auto-generated constructor stub
		super("Blood with type "+type+" near "+zip+" not found");
	}

}
