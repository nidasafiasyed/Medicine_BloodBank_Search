package com.nida.service;

import java.util.List;

import com.nida.model.Medicine;

public interface MedicineService {
	
	 List<Medicine> findAllMedicines();
	 Medicine findMedicineById(int id);
	 List<Medicine> findByName(String name);
	 Medicine insertMedicine(Medicine medicine);
	 Medicine updateMedicine(int id, Medicine med);
	 void deleteMedicine(int id);

}
