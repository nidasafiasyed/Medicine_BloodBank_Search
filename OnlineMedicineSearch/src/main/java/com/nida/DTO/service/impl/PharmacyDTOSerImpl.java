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
public class PharmacyDTOSerImpl implements PharmacyDTOService {
	
	static Logger log = Logger.getLogger(PharmacyDTOSerImpl.class.getName());
	
	@Autowired
	PharmacyDTORepo pharmacyRepo;

	@Override
	public List<PharmacySearchDTO> searchPharmacy(String name, int zip) {
		// TODO Auto-generated method stub
		List<Integer> zipNearby = Arrays.asList(zip-2, zip-1, zip, zip+1, zip+2);
		List<PharmacySearchDTO> pharmacies = pharmacyRepo.searchByName(name, zipNearby);
		
		if(pharmacies.isEmpty()) {
			log.info("Empty pharmacy list");
			throw new PharmacyNotFoundException(name, zip);
		}
		
		else {
		log.info("Found all pharmacies");
		return pharmacies;
		}
	}
	}



