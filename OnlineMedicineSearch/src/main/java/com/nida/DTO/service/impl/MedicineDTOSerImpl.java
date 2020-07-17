package com.nida.DTO.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.DTO.MedicineSearchDTO;
import com.nida.DTO.repo.MedicineDTORepo;
import com.nida.DTO.service.MedicineDTOService;
import com.nida.exception.MedicineNotFoundException;

@Service
public class MedicineDTOSerImpl implements MedicineDTOService {

	static Logger log = Logger.getLogger(MedicineDTOSerImpl.class.getName());

	@Autowired
	MedicineDTORepo medicineRepo;

	@Override
	public List<MedicineSearchDTO> searchMedicine(String name, int zip) {
		// TODO Auto-generated method stub
		
		List<Integer> zipNearby = new ArrayList<Integer>(Arrays.asList(zip));
		
		for (int i = 1; i < 6; i++) {
			zipNearby.add(zip-i);
			zipNearby.add(zip+i);
		}
		
		List<MedicineSearchDTO> medicines = medicineRepo.searchByName(name, zipNearby);
		
		if(medicines.isEmpty()) {
			log.info("Empty pharmacy list");
			throw new MedicineNotFoundException(name, zip);
		}
		
		else {
		log.info("Found all pharmacies");
		return medicines;
		}
	}
	}

	
