package com.nida.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.exception.BloodBankNotFoundException;
import com.nida.model.Blood;
import com.nida.model.BloodBank;
import com.nida.model.BloodType;
import com.nida.repo.BloodBankRepo;
import com.nida.repo.BloodRepo;
import com.nida.service.BloodBankService;

@Service
public class BloodBankServiceImpl implements BloodBankService{
	
	@Autowired
	BloodRepo bloodRepo;
	
	@Autowired
	BloodBankRepo bloodBankRepo;
	
	static Logger log = Logger.getLogger(BloodBankServiceImpl.class.getName());

	@Override
	public List<BloodBank> findAllBloodBanks() {
		// TODO Auto-generated method stub
		List<BloodBank> bloodBanks = bloodBankRepo.findAll();
		
		if(bloodBanks.isEmpty()) {
			log.info("Empty blood bank list");
			throw new BloodBankNotFoundException();
		}
		
		else {
		log.info("Found all blood banks");
		return bloodBanks;
		}
	}
	

	@Override
	public BloodBank findBloodBankById(int id) {
		// TODO Auto-generated method stub
		
		if(bloodBankRepo.existsById(id)) {
			log.info("Found blood bank with ID "+id);
			return bloodBankRepo.findById(id).get();
		}
		else {
			log.info("Did not find blood bank with ID "+id);
			throw new BloodBankNotFoundException(id);
		}
	}

	@Override
	public BloodBank insertBloodBank(BloodBank bb) {
		// TODO Auto-generated method stub
		Set<Blood> bloods = new HashSet<>();
		  for (BloodType type: BloodType.values()) {
              Blood blood = new Blood(type);
              bloods.add(blood);
          }
		
		bb.setBloodlist(bloods);
		
		log.info("Added blood bank with ID "+bb.getBloodbankId());
		return bloodBankRepo.save(bb);
	}

	@Override
	public BloodBank updateBloodBank(int id, BloodBank bb) {
		// TODO Auto-generated method stub
		
		if(!bloodBankRepo.existsById(id)) {
			log.info("Blood bank with "+id+" not found");
			throw new BloodBankNotFoundException(id);
		}
		
		else {
		
		BloodBank bloodBank = bloodBankRepo.findById(id).get();
		
		if(bb.getName()!=null) {
			bloodBank.setName(bb.getName());
			log.info("Updated blood bank "+id+" to "+bb.getName()+" name");
		}
		
		if(bb.getStreet()!=null) {
			bloodBank.setStreet(bb.getStreet());
			log.info("Updated blood bank "+id+" to "+bb.getStreet()+" street");
		}

		if(bb.getCity()!=null) {
			bloodBank.setCity(bb.getCity());
			log.info("Updated blood bank "+id+" to "+bb.getCity()+" city");
		}
		
		if(bb.getState()!=null) {
			bloodBank.setState(bb.getState());
			log.info("Updated blood bank "+id+" to "+bb.getState()+" state");
		}
		
		if(String.valueOf(bb.getZipcode()).length() == 5) {
			  bloodBank.setZipcode(bb.getZipcode());
			 log.info("Updated blood bank "+id+" to "+bb.getZipcode()+" zipcode");
		  }
		
		  bloodBank.setIs24hrs(bb.isIs24hrs());
		  log.info("Updated blood bank "+id+" 24 hrs status");
		  
		  return bloodBankRepo.save(bloodBank);
		
	}
		}

	@Override
	public void deleteBloodBank(int id) {
		// TODO Auto-generated method stub

		if(bloodBankRepo.existsById(id)) {
			bloodBankRepo.deleteById(id);
			log.info("Blood bank with "+id+" deleted");
		}
		else {
			log.info("Blood bank with "+id+" not found");
			throw new BloodBankNotFoundException(id);
		}
	}

}
