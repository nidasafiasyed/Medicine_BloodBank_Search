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
@Table(name="bloodlist")
public class Blood implements Serializable{
	
	@Id
	@Column(name = "blood_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bloodId;
	
	private BloodType type;
	
	private double units;
	
	@ManyToMany
	private Set<BloodBank> bloodBanks = new HashSet<>();

	public Blood() {
		super();
	}

	public int getBloodId() {
		return bloodId;
	}

	public void setBloodId(int bloodId) {
		this.bloodId = bloodId;
	}

	public BloodType getType() {
		return type;
	}

	public void setType(BloodType type) {
		this.type = type;
	}

	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

	public Set<BloodBank> getBloodBanks() {
		return bloodBanks;
	}

	public void setBloodBanks(Set<BloodBank> bloodBanks) {
		this.bloodBanks = bloodBanks;
	}
	
	
	

}
