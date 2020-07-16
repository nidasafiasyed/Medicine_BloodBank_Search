package com.nida.DTO.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.DTO.BloodSearchDTO;
import com.nida.DTO.repo.BloodDTORepo;
import com.nida.DTO.service.BloodDTOService;
import com.nida.exception.BloodNotFoundException;
import com.nida.model.BloodType;

@Service
public class BloodDTOSerImpl implements BloodDTOService {
	
	static Logger log = Logger.getLogger(BloodDTOSerImpl.class.getName());
	
	@Autowired
	BloodDTORepo bloodRepo;

	@Override
	public List<BloodSearchDTO> searchBlood(BloodType type, int zip) {
		// TODO Auto-generated method stub
		List<Integer> zipNearby = Arrays.asList(zip-2, zip-1, zip, zip+1, zip+2); 
		
		List<BloodSearchDTO> bloodList = bloodRepo.searchByName(type, zipNearby);
		
		if(bloodList.isEmpty()) {
			log.info("Empty blood list");
			throw new BloodNotFoundException(type, zip);
		}
		
		else {
		log.info("Found all blood types");
		return bloodList;
		}
	}

}
