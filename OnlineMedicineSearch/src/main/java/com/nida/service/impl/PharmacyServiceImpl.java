package com.nida.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.exception.PharmacyNotFoundException;
import com.nida.model.Pharmacy;
import com.nida.repo.PharmacyRepo;
import com.nida.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {
	
	@Autowired
	private PharmacyRepo pharmacyRepo;
	
	static Logger log = Logger.getLogger(PharmacyServiceImpl.class.getName());

	@Override
	public List<Pharmacy> findAllPharmacies() {
		// TODO Auto-generated method stub
		List<Pharmacy> pharmacies = pharmacyRepo.findAll();
		
		if(pharmacies.isEmpty()) {
			log.info("Empty pharmacy list");
			throw new PharmacyNotFoundException();
		}
		
		else {
		log.info("Found all pharmacies");
		return pharmacies;
		}
	}
	
	@Override
	public Pharmacy findPharmacyById(int id) {
		// TODO Auto-generated method stub
		
		if(pharmacyRepo.existsById(id)) {
			log.info("Found pharmacy with ID "+id);
			return pharmacyRepo.findById(id).get();
		}
		else {
			log.info("Did not find pharmacy with ID "+id);
			throw new PharmacyNotFoundException(id);
		}
	}

	@Override
	public Pharmacy insertPharmacy(Pharmacy pharmacy) {
		// TODO Auto-generated method stub
		log.info("Added pharmacy with ID "+pharmacy.getPharmaId());
		return pharmacyRepo.save(pharmacy);
	}

	@Override
	public Pharmacy updatePharmacy(int pharmaId, Pharmacy pharmacy) {
		// TODO Auto-generated method stub

		  if(pharmacyRepo.existsById(pharmaId)) {
			  Pharmacy pharma = pharmacyRepo.findById(pharmaId).get();
			  
			  if(pharmacy.getName()!=null) {
				  pharma.setName(pharmacy.getName());
				  log.info("Updated pharmacy "+pharmaId+" name to "+pharmacy.getName());
			  }
			  
			  if(pharmacy.getStreet()!=null) {
				  pharma.setStreet(pharmacy.getStreet());
				 log.info("Updated pharmacy "+pharmaId+" address with "+pharmacy.getStreet());
			  }
			  
			  if(pharmacy.getCity()!=null) {
				  pharma.setCity(pharmacy.getCity());
				 log.info("Updated pharmacy "+pharmaId+" address with "+pharmacy.getCity());
			  }
			  
			  if(pharmacy.getState()!=null) {
				  pharma.setState(pharmacy.getState());
				 log.info("Updated pharmacy "+pharmaId+" address with "+pharmacy.getState());
			  }
			  
			  
			  if(String.valueOf(pharmacy.getZipcode()).length() == 5) {
				  pharma.setZipcode(pharmacy.getZipcode());
				 log.info("Updated pharmacy "+pharmaId+" address with "+pharmacy.getZipcode());
			  }
			  
			  pharma.setDelivery(pharmacy.isDelivery());
			  log.info("Updated pharmacy "+pharmaId+" delivery status");
			  pharma.setIs24hrs(pharmacy.isIs24hrs());
			  log.info("Updated pharmacy "+pharmaId+" 24 hrs status");
			  
			  return pharmacyRepo.save(pharma);
		  }
		  
		  else {
			  log.info("Pharmacy with ID "+pharmaId+" not found");
			  throw new PharmacyNotFoundException(pharmaId);
			  }
	}

	@Override
	public void deletePharmacy(int pharmaId) {
		// TODO Auto-generated method stub
		
		if(pharmacyRepo.existsById(pharmaId)) {
			pharmacyRepo.deleteById(pharmaId);
			log.info("Pharmacy with "+pharmaId+" deleted");
		}
		else {
			log.info("Pharmacy with "+pharmaId+" not found");
			throw new PharmacyNotFoundException(pharmaId);
		}

	}



}
