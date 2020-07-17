package com.nida.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.exception.BloodBankNotFoundException;
import com.nida.exception.BloodNotFoundException;
import com.nida.model.Blood;
import com.nida.model.BloodBank;
import com.nida.model.BloodType;
import com.nida.repo.BloodBankRepo;
import com.nida.repo.BloodRepo;
import com.nida.service.BloodService;

@Service
public class BloodServiceImpl implements BloodService {
	
	@Autowired
	BloodRepo bloodRepo;
	
	@Autowired
	BloodBankRepo bloodBankRepo;
	
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
	public List<Blood> findBloodByType(BloodType type) {
		// TODO Auto-generated method stub
        List<Blood> blood = bloodRepo.findBloodByType(type);
		
		if(!blood.isEmpty()) {
			log.info("Found blood with type "+type);
			return blood;
		}
		
		else {
			log.info("blood with "+type+" not found");
			throw new BloodNotFoundException(type);
		}
	}
	

	@Override
	public Blood updateBlood(int bbId, Blood blood) {
		// TODO Auto-generated method stub
		
		if(!bloodBankRepo.existsById(bbId)) {
			throw new BloodBankNotFoundException(bbId);
		}

		else {
			 BloodBank bloodBank = bloodBankRepo.findById(bbId).get();
		     Set<Blood> bloods = bloodBank.getBloodlist();
			 
		     int bloodId = 0;
		     
			 for (Blood b : bloods) {
				if(b.getType()==blood.getType()) {
					bloodId += b.getId();
				}
			}
			 
			 if(bloodId == 0) {
					throw new BloodNotFoundException(bloodId);
				}
			 
			 Blood bl = bloodRepo.findById(bloodId).get();
			   
			 double units = bl.getUnits();
			 bl.setUnits(units+blood.getUnits());
			  
			 return bloodRepo.save(bl);
		  }
	}

}
