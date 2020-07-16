package com.nida.DTO;

import com.nida.model.BloodType;

public class BloodBankSearchDTO {
	
	private String blBankName;
	private String blBankStreet;
	private String blBankCity;
	private String blBankState;
	private int blBankZipcode;
	private BloodType bloodType;
	private double bloodUnits;
	private boolean is24hrs;
	
	
	public BloodBankSearchDTO(String blBankName, String blBankStreet, String blBankCity, String blBankState,
			int blBankZipcode, BloodType bloodType, double bloodUnits, boolean is24hrs) {
		super();
		this.blBankName = blBankName;
		this.blBankStreet = blBankStreet;
		this.blBankCity = blBankCity;
		this.blBankState = blBankState;
		this.blBankZipcode = blBankZipcode;
		this.bloodType = bloodType;
		this.bloodUnits = bloodUnits;
		this.is24hrs = is24hrs;
	}


	public String getBlBankName() {
		return blBankName;
	}


	public void setBlBankName(String blBankName) {
		this.blBankName = blBankName;
	}


	public String getBlBankStreet() {
		return blBankStreet;
	}


	public void setBlBankStreet(String blBankStreet) {
		this.blBankStreet = blBankStreet;
	}


	public String getBlBankCity() {
		return blBankCity;
	}


	public void setBlBankCity(String blBankCity) {
		this.blBankCity = blBankCity;
	}


	public String getBlBankState() {
		return blBankState;
	}


	public void setBlBankState(String blBankState) {
		this.blBankState = blBankState;
	}


	public int getBlBankZipcode() {
		return blBankZipcode;
	}


	public void setBlBankZipcode(int blBankZipcode) {
		this.blBankZipcode = blBankZipcode;
	}


	public BloodType getBloodType() {
		return bloodType;
	}


	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}


	public double getBloodUnits() {
		return bloodUnits;
	}


	public void setBloodUnits(double bloodUnits) {
		this.bloodUnits = bloodUnits;
	}


	public boolean isIs24hrs() {
		return is24hrs;
	}


	public void setIs24hrs(boolean is24hrs) {
		this.is24hrs = is24hrs;
	}


	@Override
	public String toString() {
		return "BloodBankSearchDTO [blBankName=" + blBankName + ", blBankStreet=" + blBankStreet + ", blBankCity="
				+ blBankCity + ", blBankState=" + blBankState + ", blBankZipcode=" + blBankZipcode + ", bloodType="
				+ bloodType + ", bloodUnits=" + bloodUnits + ", is24hrs=" + is24hrs + "]";
	}

	
}
