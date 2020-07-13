package com.nida.DTO;

import java.util.List;

import com.nida.model.Medicine;

public interface MedicineDTO {
	
	Medicine findMedicineById(int id);
	List<Medicine> findMedicineByName(String name);
	

}
