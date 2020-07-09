package com.nida.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.model.MedicineModel;
import com.nida.model.PharmacyModel;
import com.nida.repo.MedicineRepo;
import com.nida.repo.PharmacyRepo;
import com.nida.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {
	
	@Autowired
	PharmacyRepo pharmaRepo;
	
	@Autowired
	MedicineRepo medRepo;

	@Override
	public List<PharmacyModel> findAll() {
		// TODO Auto-generated method stub
		return pharmaRepo.findAll();
	}

	@Override
	public PharmacyModel findById(int pharmaId) {
		// TODO Auto-generated method stub
		Optional<PharmacyModel> pharma = pharmaRepo.findById(pharmaId);
	     if(pharma.isPresent()) {
	    	 return pharma.get();
	     }
	     return null;
	}
	
	@Override
	public List<PharmacyModel> findByName(String name) {
		// TODO Auto-generated method stub
		return pharmaRepo.findAll();
	}

	@Override
	public List<PharmacyModel> findByAddress(String zipcode) {
		// TODO Auto-generated method stub
		return pharmaRepo.findAll();
	}

	@Override
	public void insertPharmacy(PharmacyModel pharmacy) {
		// TODO Auto-generated method stub
		pharmaRepo.save(pharmacy);
		System.out.println("New pharmacy added!");
	}

	@Override
	public void updatePharmacy(int pharmaId) {
		// TODO Auto-generated method stub
		
		 Optional<PharmacyModel> pharma = pharmaRepo.findById(pharmaId);
	   	   
		   if(pharma==null) {
		    	System.out.println("Medicine not found");
		    }

		    if(pharma.isPresent()) {
		    PharmacyModel pharmacy = pharma.get();
		    
		    pharmacy.setName("new name");
		    pharmacy.setDelivery(false);
		    pharmacy.setIs24hrs(true);
		  
		    LinkedHashMap<String, String> newAddress = pharmacy.getAddress();
		    newAddress.put("street", "new street");
		    pharmacy.setAddress(newAddress);
		    
		    List<MedicineModel> medicines = pharmacy.getMedicines();
		    
		    Optional<MedicineModel> med = medRepo.findById(101);//dummy
		     if(med.isPresent()) {
		    	 medicines.add(med.get());
		     }
		     
		    pharmacy.setMedicines(medicines);
		    
		    pharmaRepo.save(pharmacy);
		    
		    System.out.println("Pharmacy updated");
		     }

	}

	@Override
	public void deletePharmacy(int pharmaId) {
		// TODO Auto-generated method stub
		pharmaRepo.delete(pharmaRepo.findById(pharmaId).get());

	}

}
