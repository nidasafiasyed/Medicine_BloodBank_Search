package com.nida.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
	
	private LinkedHashMap<String,String> address = new LinkedHashMap<String, String>();
	
	private boolean is24hrs;
	
	private boolean delivery;
	
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "pharmacies")
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
	
	public LinkedHashMap<String, String> getAddress() {
		return address;
	}
	
	public void setAddress(LinkedHashMap<String, String> address) {
		this.address.putIfAbsent("street", "");
		this.address.putIfAbsent("city", "");
		this.address.putIfAbsent("state", "");
		this.address.putIfAbsent("zip", "");
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

	
	 public Set<Medicine> getMedicines() { 
		 return medicines; 
	}
	 
	 public void setMedicines(Set<Medicine> medicines) { 
		 this.medicines = medicines; 
	}

	public Pharmacy(int pharmaId, String name, LinkedHashMap<String, String> address, boolean is24hrs,
			boolean delivery) {
		super();
		this.pharmaId = pharmaId;
		this.name = name;
		this.address = address;
		this.is24hrs = is24hrs;
		this.delivery = delivery;
	}
	 
	 

}
