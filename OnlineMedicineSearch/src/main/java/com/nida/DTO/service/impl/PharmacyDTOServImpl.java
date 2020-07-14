package com.nida.DTO.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.DTO.PharmacySearchDTO;
import com.nida.DTO.repo.PharmacyDTORepo;
import com.nida.DTO.service.PharmacyDTOService;
import com.nida.exception.PharmacyNotFoundException;

@Service
public class PharmacyDTOServImpl implements PharmacyDTOService {
	
	static Logger log = Logger.getLogger(PharmacyDTOServImpl.class.getName());
	
	@Autowired
	PharmacyDTORepo pharmacyRepo;

	@Override
	public List<PharmacySearchDTO> searchPharmacy(String name, int zip) {
		// TODO Auto-generated method stub
		int zipnearby[] = {zip-2, zip-1, zip, zip+1, zip+2};
		List<String> zipArray = Arrays.asList((Arrays.stream(zipnearby)
				.mapToObj(String::valueOf))
				.toArray(String[]::new));
		List<PharmacySearchDTO> pharmacies = pharmacyRepo.searchByName(name, zipArray);
		
		if(pharmacies.isEmpty()) {
			log.info("Empty pharmacy list");
			throw new PharmacyNotFoundException();
		}
		
		else {
		log.info("Found all pharmacies");
		return pharmacies;
		}
	}
	}



