package com.nida.DTO;

import java.util.List;

import com.nida.model.Pharmacy;

public interface PharmacyDTO {
	
	List<Pharmacy> findPharmacyByName(String name);
	Pharmacy findPharmacyById(int id);
	List<Pharmacy> findPharmacyByAddress(int zip);

}
