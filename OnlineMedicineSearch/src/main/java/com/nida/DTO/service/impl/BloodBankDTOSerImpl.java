package com.nida.DTO.service.impl;

import java.util.ArrayList;
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

		List<Integer> zipNearby = new ArrayList<Integer>(Arrays.asList(zip));
		
		for (int i = 1; i < 6; i++) {
			zipNearby.add(zip-i);
			zipNearby.add(zip+i);
		}
		
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
