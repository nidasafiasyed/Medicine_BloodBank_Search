package com.nida.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.exception.BloodBankNotFoundException;
import com.nida.exception.BloodNotFoundException;
import com.nida.model.Blood;
import com.nida.model.BloodBank;
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
		Optional<BloodBank> bbornull = bloodBankRepo.findById(id);
		if(bbornull.isPresent()) {
			log.info("Found blood bank with ID "+id);
			return bbornull.get();
		}
		else {
			log.info("Did not find blood bank with ID "+id);
			throw new BloodBankNotFoundException(id);
		}
	}

	@Override
	public BloodBank insertBloodBank(BloodBank bb) {
		// TODO Auto-generated method stub
		log.info("Added blood bank with ID "+bb.getBloodbankId());
		return bloodBankRepo.save(bb);
	}

	@Override
	public BloodBank updateBloodBank(int id, BloodBank bb) {
		// TODO Auto-generated method stub
		Optional<BloodBank> bbornull = bloodBankRepo.findById(id);
		
		if(!bbornull.isPresent()) {
			log.info("Blood bank with "+id+" not found");
			throw new BloodBankNotFoundException(id);
		}
		
		else {
			
		
		BloodBank bloodBank = bbornull.get();
		
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
		Optional<BloodBank> bloodBank = bloodBankRepo.findById(id);
		if(bloodBank.isPresent()) {
			bloodBankRepo.deleteById(id);
			log.info("Blood bank with "+id+" deleted");
		}
		else {
			log.info("Blood bank with "+id+" not found");
			throw new BloodBankNotFoundException(id);
		}
	}

	@Override
	public BloodBank addBloodToBloodBank(int bbId, Blood blood) {
		// TODO Auto-generated method stub
		
		Optional<BloodBank> bbornull = bloodBankRepo.findById(bbId);
		Optional<Blood> bloodornull = bloodRepo.findById(blood.getBloodId());
		
		  if(!bbornull.isPresent()) {
			 throw new BloodBankNotFoundException(bbId);
		  }
		
		  if(!bloodornull.isPresent()) {
				 throw new BloodNotFoundException(blood.getBloodId());
		  }
		  
		  Blood addBlood = bloodornull.get();
	      BloodBank bloodBank = bbornull.get();
	      
		  Set<Blood> bloodList = bloodBank.getBloodlist();

		  double units = 0;
		  
		  for(Blood b: bloodList) {
			  int id = b.getBloodId();
			  if(id == addBlood.getBloodId())
			  {
				  units = b.getUnits();
				  bloodList.remove(b);
			  }
		  }
		  
		  units += addBlood.getUnits();
		  addBlood.setUnits(units);
		  bloodRepo.save(addBlood);
		  
		  bloodList.add(addBlood);
		  bloodBank.setBloodlist(bloodList);

		  log.info("Added "+blood.getUnits()+" units of blood "+ blood.getType() +" to blood bank "+bbId);
		  
		  return bloodBankRepo.save(bloodBank);
}

}
