package com.nida.service;

import java.util.List;

import com.nida.model.MedicineModel;

public interface MedicineService {
	
	 List<MedicineModel> findAll();
	 MedicineModel findById(int id);
	 List<MedicineModel> findByName(String name);
	 void insertMedicine(MedicineModel medicine);
	 void updateMedicine(int id);
	 void deleteMedicine(int id);

}
