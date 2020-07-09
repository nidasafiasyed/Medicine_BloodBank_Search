package com.nida.service;

import java.util.List;

import com.nida.model.PharmacyModel;

public interface PharmacyService {
	
	 List<PharmacyModel> findAll();
	 PharmacyModel findById(int id);
	 List<PharmacyModel> findByName(String name);
	 List<PharmacyModel> findByAddress(String zip);
	 void insertPharmacy(PharmacyModel pharmacy);
	 void updatePharmacy(int id);
	 void deletePharmacy(int id);

}
