package com.nida.DTO;

import java.util.List;

import com.nida.model.Medicine;

public interface MedicineSearch {
	
	
	List<Medicine> findMedicineByName(String name, int zip);
	

}
