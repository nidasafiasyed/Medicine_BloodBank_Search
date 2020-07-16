package com.nida.DTO.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.DTO.BloodBankSearchDTO;
import com.nida.DTO.repo.BloodBankDTORepo;
import com.nida.DTO.service.BloodBankDTOService;
import com.nida.exception.BloodBankNotFoundException;

@Service
public class BloodBankDTOSerImpl implements BloodBankDTOService{
	
	static Logger log = Logger.getLogger(BloodBankDTOSerImpl.class.getName());
	
	@Autowired
	BloodBankDTORepo bloodBankRepo;

	@Override
	public List<BloodBankSearchDTO> searchBloodBank(String name, int zip) {
		// TODO Auto-generated method stub
		List<Integer> zipNearby = Arrays.asList(zip-2, zip-1, zip, zip+1, zip+2);
		List<BloodBankSearchDTO> bloodBanks = bloodBankRepo.searchByName(name, zipNearby);
		
		if(bloodBanks.isEmpty()) {
			log.info("Empty blood bank list");
			throw new BloodBankNotFoundException(name, zip);
		}
		
		else {
		log.info("Found all blood banks");
		return bloodBanks;
		}
	}

}
