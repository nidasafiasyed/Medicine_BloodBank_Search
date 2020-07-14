package com.nida.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pharmacies")
public class Pharmacy implements Serializable{
	
	@Id
	@Column(name = "pharmacy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pharmaId;
	
	private String name;

	private String street;
	private String city;
	private String state;
	
	private int zipcode;
	
	private boolean is24hrs;
	
	private boolean delivery;
	
	
	@ManyToMany
	private Set<Medicine> medicines = new HashSet<>();
	 
	
	public int getPharmaId() {
		return pharmaId;
	}
	
	public void setPharmaId(int pharmaId) {
		this.pharmaId = pharmaId;
	}

	public Pharmacy() {
		super();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
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

	
	 public Set<Medicine> getMedicines() { 
		 return medicines; 
	}
	 
	 public void setMedicines(Set<Medicine> medicines) { 
		 this.medicines = medicines; 
	}
	 

}
