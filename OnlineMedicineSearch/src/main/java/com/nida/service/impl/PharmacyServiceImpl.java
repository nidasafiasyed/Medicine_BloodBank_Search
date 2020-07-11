package com.nida.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.model.Medicine;
import com.nida.model.Pharmacy;
import com.nida.repo.PharmacyRepo;
import com.nida.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {
	
	@Autowired
	private PharmacyRepo pharmacyRepo;

	@Override
	public List<Pharmacy> findAllPharmacies() {
		// TODO Auto-generated method stub
		return pharmacyRepo.findAll();
	}

	@Override
	public Pharmacy findPharmacyById(int pharmaId) {
		// TODO Auto-generated method stub
		Optional<Pharmacy> pharmacy = pharmacyRepo.findById(pharmaId);
		if(pharmacy.isPresent()) {
			return pharmacy.get();
		}
		return null;
	}
	
	@Override
	public List<Pharmacy> findPharmacyByName(String name) {
		// TODO Auto-generated method stub
		List<Pharmacy> pharmacies = pharmacyRepo.findByName(name);
		return pharmacies;
	}

	@Override
	public List<Pharmacy> findPharmacyByAddress(String zip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pharmacy insertPharmacy(Pharmacy pharmacy) {
		// TODO Auto-generated method stub
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
			  }
			  
			  //need to define properly
			  if(!pharmacy.getAddress().isEmpty()) {
				  
				  LinkedHashMap<String, String> ad = pharma.getAddress();
				  ad.putIfAbsent("street", "");
				  ad.putIfAbsent("city", "");
				  ad.putIfAbsent("state", "");
				  ad.putIfAbsent("zipcode", "");
				  
				  ad.putAll(pharmacy.getAddress());
				  
				 pharma.setAddress(ad);  
			  }
			  
			  //how?
			  pharma.setDelivery(pharmacy.isDelivery());
			  pharma.setIs24hrs(pharmacy.isIs24hrs());
			  
			  
			  if(!pharmacy.getMedicines().isEmpty()) {
			  Set<Medicine> med = pharma.getMedicines();
			  med.addAll(pharmacy.getMedicines());
			  pharma.setMedicines(med);
			  
			  }
			  return pharmacyRepo.save(pharma);
		  }
		  
		  return null;
	}

	@Override
	public void deletePharmacy(int pharmaId) {
		// TODO Auto-generated method stub
		Optional<Pharmacy> pharmacy = pharmacyRepo.findById(pharmaId);
		if(pharmacy.isPresent()) {
			pharmacyRepo.deleteById(pharmaId);
		}

	}

	

}
