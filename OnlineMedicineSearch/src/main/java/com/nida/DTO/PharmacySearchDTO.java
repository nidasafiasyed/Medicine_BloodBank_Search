package com.nida.DTO;


public class PharmacySearchDTO {
	
    private String pharmaName;
	private String pharmaAddress;
	private boolean is24hrs;
	private boolean delivery;
	private String medName;
	private String medDosage;
	
	
	public PharmacySearchDTO(String pharmaName, String pharmaAddress, boolean is24hrs, boolean delivery,
			String medName, String medDosage) {
		super();
		this.pharmaName = pharmaName;
		this.pharmaAddress = pharmaAddress;
		this.is24hrs = is24hrs;
		this.delivery = delivery;
		this.medName = medName;
		this.medDosage = medDosage;
	}


	public String getPharmaName() {
		return pharmaName;
	}


	public void setPharmaName(String pharmaName) {
		this.pharmaName = pharmaName;
	}


	public String getPharmaAddress() {
		return pharmaAddress;
	}


	public void setPharmaAddress(String pharmaAddress) {
		this.pharmaAddress = pharmaAddress;
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


	public String getMedName() {
		return medName;
	}


	public void setMedName(String medName) {
		this.medName = medName;
	}


	public String getMedDosage() {
		return medDosage;
	}


	public void setMedDosage(String medDosage) {
		this.medDosage = medDosage;
	}


	@Override
	public String toString() {
		return "PharmacySearchDTO [pharmaName=" + pharmaName + ", pharmaAddress=" + pharmaAddress + ", is24hrs="
				+ is24hrs + ", delivery=" + delivery + ", medName=" + medName + ", medDosage=" + medDosage + "]";
	}
	

}
