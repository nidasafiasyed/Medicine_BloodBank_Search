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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="bloodbanks")
public class BloodBank implements Serializable{
	
	@Id
	@Column(name = "bloodbank_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bloodbankId;
	
	private String name;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private boolean is24hrs;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="bloodlist_bloodbanks", joinColumns = {@JoinColumn(name="bloodbank_id")}, inverseJoinColumns =
	{@JoinColumn(name="blood_id")})
	private Set <Blood> bloodlist = new HashSet<>();
	
	private double units;


	public int getBloodbankId() {
		return bloodbankId;
	}


	public void setBloodbankId(int bloodbankId) {
		this.bloodbankId = bloodbankId;
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
		return bloodlist;
	}


	public void setBloodlist(Set<Blood> bloodlist) {
		this.bloodlist = bloodlist;
	}


	public double getUnits() {
		return units;
	}


	public void setUnits(double units) {
		this.units = units;
	}


	public BloodBank() {
		super();
	}
	
}
