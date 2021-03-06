package com.nida.service;

import java.util.List;
import com.nida.model.Pharmacy;

public interface PharmacyService {
	
	 List<Pharmacy> findAllPharmacies();
	 Pharmacy findPharmacyById(int id);
	 Pharmacy insertPharmacy(Pharmacy pharmacy);
	 Pharmacy updatePharmacy(int id, Pharmacy ph);
	 void deletePharmacy(int id);

}
