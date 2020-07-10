package com.nida.service.impl;

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
	public List<Pharmacy> findByName(String name) {
		// TODO Auto-generated method stub
		return pharmacyRepo.findAll();
	}

	@Override
	public List<Pharmacy> findByAddress(String zipcode) {
		// TODO Auto-generated method stub
		return pharmacyRepo.findAll();
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
			  
			  pharma.setPharmaId(pharmacy.getPharmaId());
			  pharma.setName(pharmacy.getName());
			  pharma.setAddress(pharmacy.getAddress());
			  
			  pharma.setDelivery(pharmacy.isDelivery());
			  pharma.setIs24hrs(pharmacy.isIs24hrs());
			  
			  Set<Medicine> med = pharma.getMedicines();
			  med.addAll(pharmacy.getMedicines());
			  pharma.setMedicines(med);
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
