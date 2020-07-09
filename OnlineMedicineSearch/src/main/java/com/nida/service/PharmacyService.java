package com.nida.service;

import java.util.List;

import com.nida.model.Pharmacy;

public interface PharmacyService {
	
	 List<Pharmacy> findAll();
	 Pharmacy findById(int id);
	 List<Pharmacy> findByName(String name);
	 List<Pharmacy> findByAddress(String zip);
	 void insertPharmacy(Pharmacy pharmacy);
	 void updatePharmacy(int id);
	 void deletePharmacy(int id);

}
