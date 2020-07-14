package com.nida.exception;

public class MedicineNotFoundException extends RuntimeException{

	public MedicineNotFoundException(int medId) {
		// TODO Auto-generated constructor stub
		super("Medicine with ID "+medId+" not found");
	}
	
	public MedicineNotFoundException(String name) {
		// TODO Auto-generated constructor stub
		super("Medicine with name "+name+" not found");
	}
	
	public MedicineNotFoundException() {
		// TODO Auto-generated constructor stub
		super("There are no medicines here");
	}

	public MedicineNotFoundException(String name, int zip) {
		// TODO Auto-generated constructor stub
		super("Medicine with name "+name+" near "+zip+" not found");
	}
}


