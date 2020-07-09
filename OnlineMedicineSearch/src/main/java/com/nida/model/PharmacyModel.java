package com.nida.model;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pharmacies")
public class PharmacyModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pharmaId;
	
	private String name;
	LinkedHashMap<String,String> address;
	private boolean is24hrs;
	private boolean delivery;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "Pharmacies")
	List<MedicineModel> medicines;
	
	public int getPharmaId() {
		return pharmaId;
	}
	
	public PharmacyModel() {
		address.putIfAbsent("street", "");
		address.putIfAbsent("city", "");
		address.putIfAbsent("state", "");
		address.putIfAbsent("zip", "");
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

	public List<MedicineModel> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<MedicineModel> medicines) {
		this.medicines = medicines;
	}

	@Override
	public String toString() {
		return "PharmacyModel [pharmaId=" + pharmaId + ", name=" + name + ", address=" + address + ", is24hrs="
				+ is24hrs + ", delivery=" + delivery + ", medicines=" + medicines + "]";
	}
	
	

}
