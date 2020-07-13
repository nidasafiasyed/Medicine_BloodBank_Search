package com.nida.service;

import java.util.List;
import com.nida.model.Medicine;
import com.nida.model.Pharmacy;

public interface MedicineService {
	
	 List<Medicine> findAllMedicines();
	 Medicine findMedicineById(int id);
	 List<Medicine> findMedicineByName(String name);
	 Medicine insertMedicine(Medicine medicine);
	 Medicine updateMedicine(int id, Medicine med);
	 void deleteMedicine(int id);
	 Medicine insertPharmacy(int medId, int pharmaId);

}
