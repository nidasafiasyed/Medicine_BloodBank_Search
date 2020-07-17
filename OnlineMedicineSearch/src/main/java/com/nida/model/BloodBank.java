package com.nida.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="bloodbanks")
public class BloodBank implements Serializable{
	
	@Id
	@Column(name = "bloodbank_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private boolean is24hrs;
	
	@JsonManagedReference
	@OneToMany(
		        mappedBy = "bloodBank",
		        cascade = CascadeType.ALL
		    )
	private Set <Blood> bloodList = new HashSet<>();
	
	private double units;


	public int getBloodbankId() {
		return id;
	}


	public void setBloodbankId(int id) {
		this.id = id;
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


	public Set<Blood> getBloodlist() {
		return bloodList;
	}


	public void setBloodlist(Set<Blood> bloodlist) {
		this.bloodList = bloodlist;
		for(Blood blood : bloodlist) {
			blood.setBloodBank(this);
		}
	}


	public double getUnits() {
		return units;
	}


	public void setUnits(double units) {
		this.units = units;
	}


	public BloodBank() {
		bloodList = new HashSet<>();
	}
	
}
