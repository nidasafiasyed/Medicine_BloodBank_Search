package com.nida.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="bloodlist")
public class Blood implements Serializable{
	
	@Id
	@Column(name = "blood_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private BloodType type;
	
	private double units;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bloodbank_id")
	private BloodBank bloodBank;

	public Blood() {
		super();
	}

	public Blood(BloodType type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public BloodBank getBloodBank() {
		return bloodBank;
	}

	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
		bloodBank.getBloodlist().add(this);
	}
	
	
	

}
