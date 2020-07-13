package com.nida.service;

import java.util.List;
import com.nida.model.Medicine;
import com.nida.model.Pharmacy;

public interface PharmacyService {
	
	 List<Pharmacy> findAllPharmacies();
	 Pharmacy findPharmacyById(int id);
	 List<Pharmacy> findPharmacyByName(String name);
	 List<Pharmacy> findPharmacyByAddress(int zip);
	 Pharmacy insertPharmacy(Pharmacy pharmacy);
	 Pharmacy updatePharmacy(int id, Pharmacy ph);
	 void deletePharmacy(int id);
	 Pharmacy insertMedicine(int pharmaId, int medId);

}
