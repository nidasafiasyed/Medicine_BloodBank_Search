package com.nida.exception;

import com.nida.model.BloodType;

public class BloodNotFoundException extends RuntimeException {
	
	public BloodNotFoundException(int bId) {
		// TODO Auto-generated constructor stub
		super("Blood with ID "+bId+" not found");
	}
	
	
	public BloodNotFoundException() {
		// TODO Auto-generated constructor stub
		super("There is no blood here");
	}


	public BloodNotFoundException(String name, int zip) {
		// TODO Auto-generated constructor stub
		super("Blood with name "+name+" near "+zip+" not found");
	}

	public BloodNotFoundException(BloodType type, int zip) {
		// TODO Auto-generated constructor stub
		super("Blood with type "+type+" near "+zip+" not found");
	}

	public BloodNotFoundException(BloodType type) {
		// TODO Auto-generated constructor stub
		super("Blood with type "+type+" not found");
	}

}
