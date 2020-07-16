package com.nida.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.exception.BloodNotFoundException;
import com.nida.model.Blood;
import com.nida.repo.BloodRepo;
import com.nida.service.BloodService;

@Service
public class BloodServiceImpl implements BloodService {
	
	@Autowired
	BloodRepo bloodRepo;
	
	static Logger log = Logger.getLogger(BloodServiceImpl.class.getName());

	@Override
	public List<Blood> findAllBlood() {
		// TODO Auto-generated method stub
		List<Blood> bloodlist = bloodRepo.findAll();
		if(bloodlist.isEmpty()) {
			log.info("Empty blood list");
			throw new BloodNotFoundException();
		}
		else {
			log.info("Found blood list");
			return bloodlist;
		}
	}

	@Override
	public Blood findBloodById(int id) {
		// TODO Auto-generated method stub
        Optional<Blood> bloodornull = bloodRepo.findById(id);
		
		if(bloodornull.isPresent()) {
			log.info("Found blood with ID "+id);
			return bloodornull.get();
		}
		
		else {
			log.info("blood with "+id+" not found");
			throw new BloodNotFoundException(id);
		}
	}
	

	@Override
	public Blood insertBlood(Blood blood) {
		// TODO Auto-generated method stub
		log.info("Added blood with ID "+blood.getBloodId());
		return bloodRepo.save(blood);
	}
	

	@Override
	public void deleteBlood(int id) {
		// TODO Auto-generated method stub
		Optional<Blood> blood = bloodRepo.findById(id);
		if(blood.isPresent()) {
			bloodRepo.deleteById(id);
			log.info("Blood with "+id+" deleted");
		}
		
		else {
			log.info("Blood with "+id+" not found");
			throw new BloodNotFoundException(id);
		}

	}


}
