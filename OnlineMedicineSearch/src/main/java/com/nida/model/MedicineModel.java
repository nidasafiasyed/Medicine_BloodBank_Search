package com.nida.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Medicines")
public class MedicineModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medId;
	
	private String name;
	private Double mg;
	private Set<String> ingredients;
	private Set<String> sideEffects;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Medicines&Pharmacies", joinColumns = {@JoinColumn(name="medId")},
	inverseJoinColumns = {@JoinColumn(name="pharmaId")})
	private List<PharmacyModel> pharmacies;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getMg() {
		return mg;
	}
	
	public void setMg(Double mg) {
		this.mg = mg;
	}
	
	public Set<String> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(Set<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public Set<String> getSideEffects() {
		return sideEffects;
	}
	
	public void setSideEffects(Set<String> sideEffects) {
		this.sideEffects = sideEffects;
	}
	
	public List<PharmacyModel> getPharmacies() {
		return pharmacies;
	}
	
	public void setPharmacies(List<PharmacyModel> pharmacies) {
		this.pharmacies = pharmacies;
	}

	//auto setting medid so only get()
	public int getMedId() {
		return medId;
	}

	@Override
	public String toString() {
		return "MedicineModel [medId=" + medId + ", name=" + name + ", mg=" + mg + ", ingredients=" + ingredients
				+ ", sideEffects=" + sideEffects + ", pharmacies=" + pharmacies + "]";
	}
	


}
