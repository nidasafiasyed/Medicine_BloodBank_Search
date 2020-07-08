package com.nida.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pharmacies")
public class PharmacyModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pharmaId;
	
	private String name;
	private String address;
	private boolean is24hrs;
	private boolean delivery;
	
	public int getPharmaId() {
		return pharmaId;
	}
	
	//only get()
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
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
	

}
