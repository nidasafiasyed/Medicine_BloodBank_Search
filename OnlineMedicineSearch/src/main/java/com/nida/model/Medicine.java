package com.nida.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="medicines")
public class Medicine implements Serializable{
	@Id
	@Column(name = "medicine_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medId;
	
	private String name;
	
	@Column(name="dosage")
	private Double mg;
	
	@ElementCollection
	private Set<String> ingredients = new LinkedHashSet<String>();
	
	@Column(name="side_effects")
	@ElementCollection
	private Set<String> sideEffects = new LinkedHashSet<String>();
	
	
	  @ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(name="medicines_pharmacies", joinColumns = {@JoinColumn(name="medicine_id")}, inverseJoinColumns =
	  {@JoinColumn(name="pharmacy_id")}) 
	  private Set <Pharmacy> pharmacies = new HashSet<>();
	 
	
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
	
	
	  public Set<Pharmacy> getPharmacies() { 
		  return pharmacies; 
	}
	 
	  public void setPharmacies(Set<Pharmacy> pharmacies) { 
		  this.pharmacies = pharmacies; 
		  }
	 
	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public Medicine() {
		super();
	}

	public Medicine(int medId, String name, Double mg, Set<String> ingredients, Set<String> sideEffects) {
		super();
		this.medId = medId;
		this.name = name;
		this.mg = mg;
		this.ingredients = ingredients;
		this.sideEffects = sideEffects;
	}
	
    

}
