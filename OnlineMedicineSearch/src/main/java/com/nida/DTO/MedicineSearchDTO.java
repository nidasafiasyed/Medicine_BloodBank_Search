package com.nida.DTO;


public class MedicineSearchDTO {
	
	//List<Medicine> findMedicineByName(String name, int zip);
	
	private String medName;
	private double medDosage;
    private String pharmaName;
	private String pharmaStreet;
	private String pharmaCity;
	private String pharmaState;
	private int pharmaZipCode;
	private boolean is24hrs;
	private boolean delivery;
	

	public MedicineSearchDTO(String medName, double medDosage, String pharmaName, String pharmaStreet,
			String pharmaCity, String pharmaState, int pharmaZipCode, boolean is24hrs, boolean delivery) {
		super();
		this.medName = medName;
		this.medDosage = medDosage;
		this.pharmaName = pharmaName;
		this.pharmaStreet = pharmaStreet;
		this.pharmaCity = pharmaCity;
		this.pharmaState = pharmaState;
		this.pharmaZipCode = pharmaZipCode;
		this.is24hrs = is24hrs;
		this.delivery = delivery;
	}


	public String getMedName() {
		return medName;
	}


	public void setMedName(String medName) {
		this.medName = medName;
	}


	public double getMedDosage() {
		return medDosage;
	}


	public void setMedDosage(double medDosage) {
		this.medDosage = medDosage;
	}


	public String getPharmaName() {
		return pharmaName;
	}


	public void setPharmaName(String pharmaName) {
		this.pharmaName = pharmaName;
	}


	public String getPharmaStreet() {
		return pharmaStreet;
	}


	public void setPharmaStreet(String pharmaStreet) {
		this.pharmaStreet = pharmaStreet;
	}


	public String getPharmaCity() {
		return pharmaCity;
	}


	public void setPharmaCity(String pharmaCity) {
		this.pharmaCity = pharmaCity;
	}


	public String getPharmaState() {
		return pharmaState;
	}


	public void setPharmaState(String pharmaState) {
		this.pharmaState = pharmaState;
	}


	public int getPharmaZipCode() {
		return pharmaZipCode;
	}


	public void setPharmaZipCode(int pharmaZipCode) {
		this.pharmaZipCode = pharmaZipCode;
	}


	public boolean isIs24hrs() {
		return is24hrs;
	}


	public void setIs24hrs(boolean is24hrs) {
		this.is24hrs = is24hrs;
	}


	public boolean isDelivery() {
		return delivery;
	}


	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}


	@Override
	public String toString() {
		return "MedicineSearchDTO [medName=" + medName + ", medDosage=" + medDosage + ", pharmaName=" + pharmaName
				+ ", pharmaStreet=" + pharmaStreet + ", pharmaCity=" + pharmaCity + ", pharmaState=" + pharmaState
				+ ", pharmaZipCode=" + pharmaZipCode + ", is24hrs=" + is24hrs + ", delivery=" + delivery + "]";
	}


	

}
