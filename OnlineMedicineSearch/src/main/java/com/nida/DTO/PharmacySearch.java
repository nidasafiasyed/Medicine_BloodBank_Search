package com.nida.DTO;

import java.util.List;

import com.nida.model.Pharmacy;

public interface PharmacySearch {
	
	List<Pharmacy> findPharmacyByName(String name, int zip);
	List<Pharmacy> findPharmacyByAddress(int zip);   

}
