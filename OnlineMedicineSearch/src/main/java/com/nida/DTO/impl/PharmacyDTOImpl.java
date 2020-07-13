package com.nida.DTO.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.DTO.PharmacySearch;
import com.nida.DTO.repo.PharmacyDTORepo;
import com.nida.exception.PharmacyNotFoundException;
import com.nida.model.Pharmacy;

@Service
public class PharmacyDTOImpl implements PharmacySearch {
	
	static Logger log = Logger.getLogger(PharmacyDTOImpl.class.getName());
	
	@Autowired
	PharmacyDTORepo pharmacyRepo;

	@Override
	public List<Pharmacy> findPharmacyByName(String name, int zip) {
		// TODO Auto-generated method stub
		int zipnearby[] = {zip-2, zip-1, zip, zip+1, zip+2};
		List<String> zipArray = Arrays.asList((Arrays.stream(zipnearby)
				.mapToObj(String::valueOf))
				.toArray(String[]::new));
		
		List<Pharmacy> pharmacies = pharmacyRepo.findByName(name, zipArray);
		if(pharmacies.isEmpty()) {
			log.info("Pharmacies with "+name+" not found");
			throw new PharmacyNotFoundException(name);
		}
		else {
		log.info("Pharmacies with "+name+" found");
		return pharmacies;
		}
	}

	@Override
	public List<Pharmacy> findPharmacyByAddress(int zip) {
		// TODO Auto-generated method stub
		int zipnearby[] = {zip-2, zip-1, zip, zip+1, zip+2};
		List<String> zipArray = Arrays.asList((Arrays.stream(zipnearby)
				.mapToObj(String::valueOf))
				.toArray(String[]::new));
		
		List<Pharmacy> pharmacies = pharmacyRepo.findByAddress(zipArray);
		
		if (pharmacies.isEmpty()) {
			log.info("Pharmacies near "+zip+" found");
			throw new PharmacyNotFoundException(zipArray);
		}
		
		else {
			log.info("Pharmacies near "+zip+" found");
			return pharmacies;	
		}
	}


}
