package com.nida.service;

import java.util.List;

import com.nida.model.Medicine;

public interface MedicineService {
	
	 List<Medicine> findAll();
	 Medicine findById(int id);
	 List<Medicine> findByName(String name);
	 void insertMedicine(Medicine medicine);
	 void updateMedicine(int id);
	 void deleteMedicine(int id);

}
