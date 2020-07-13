package com.nida.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.exception.MedicineNotFoundException;
import com.nida.exception.PharmacyNotFoundException;
import com.nida.model.Medicine;
import com.nida.model.Pharmacy;
import com.nida.repo.MedicineRepo;
import com.nida.repo.PharmacyRepo;
import com.nida.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {
	
	@Autowired
	private PharmacyRepo pharmacyRepo;
	
	@Autowired
	private MedicineRepo medicineRepo;
	
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
	public Pharmacy findPharmacyById(int pharmaId) {
		// TODO Auto-generated method stub
		Optional<Pharmacy> pharmacy = pharmacyRepo.findById(pharmaId);
		if(pharmacy.isPresent()) {
			log.info("Found medicine with ID "+pharmaId);
			return pharmacy.get();
		}
		else {
			log.info("Did not find pharmacy with ID "+pharmaId);
			throw new PharmacyNotFoundException(pharmaId);
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
		
		  Optional<Pharmacy> pharmaornull = pharmacyRepo.findById(pharmaId);
		  if(pharmaornull.isPresent()) {
			  Pharmacy pharma = pharmaornull.get();
			  
			  if(pharmacy.getName()!=null) {
				  pharma.setName(pharmacy.getName());
				  log.info("Updated pharmacy "+pharmaId+" name to "+pharmacy.getName());
			  }
			  
			  //need to define properly
			  if(!pharmacy.getAddress().isEmpty()) {
				  
				  Map<String, String> ad = pharma.getAddress();
				  ad.putIfAbsent("street", "");
				  ad.putIfAbsent("city", "");
				  ad.putIfAbsent("state", "");
				  ad.putIfAbsent("zipcode", "");
				  
				  ad.putAll(pharmacy.getAddress());
				  
				 pharma.setAddress(ad);
				 log.info("Updated pharmacy "+pharmaId+" address with "+pharmacy.getAddress());
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
		Optional<Pharmacy> pharmacy = pharmacyRepo.findById(pharmaId);
		if(pharmacy.isPresent()) {
			pharmacyRepo.deleteById(pharmaId);
			log.info("Pharmacy with "+pharmaId+" deleted");
		}
		else {
			log.info("Pharmacy with "+pharmaId+" not found");
			throw new PharmacyNotFoundException(pharmaId);
		}

	}

	@Override
	public List<Pharmacy> findPharmacyByName(String name) {
		// TODO Auto-generated method stub
		List<Pharmacy> pharmacies = pharmacyRepo.findByName(name);
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

	@Override
	public Pharmacy insertMedicine(int pharmaId, int medId) {
		// TODO Auto-generated method stub
		Optional<Medicine> medornull = medicineRepo.findById(medId);
		Optional<Pharmacy> pharmaornull = pharmacyRepo.findById(pharmaId);
		
		  if(!medornull.isPresent()) {
			 throw new MedicineNotFoundException(medId);
		  }
		
		  if(!pharmaornull.isPresent()) {
				 throw new PharmacyNotFoundException(pharmaId);
		  }
		  
		  Medicine med = medornull.get();
	      Pharmacy pharma = pharmaornull.get();
	      
		  Set<Medicine> md = pharma.getMedicines();
		  md.add(med);
		  pharma.setMedicines(md);
		  log.info("Added medicine "+ medId +" to pharmacy "+pharmaId);
		  
		  return pharmacyRepo.save(pharma);
		  
	     
	}

	

}
