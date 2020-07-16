package com.nida.DTO.service;

import java.util.List;

import com.nida.DTO.MedicineSearchDTO;

public interface MedicineDTOService {
	
	List<MedicineSearchDTO> searchMedicine(String name, int zip);

}
