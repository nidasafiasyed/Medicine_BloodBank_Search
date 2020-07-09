package com.nida.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.model.MedicineModel;
import com.nida.model.PharmacyModel;
import com.nida.repo.MedicineRepo;
import com.nida.repo.PharmacyRepo;
import com.nida.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	MedicineRepo medRepo;
	
	@Autowired
	PharmacyRepo pharmaRepo;

	@Override
	public List<MedicineModel> findAll() {
		// TODO Auto-generated method stub
		return medRepo.findAll();
	}

	@Override
	public MedicineModel findById(int medId) {
		// TODO Auto-generated method stub
		 Optional<MedicineModel> med = medRepo.findById(medId);
	     if(med.isPresent()) {
	    	 return med.get();
	     }
	     return null;
	}

	@Override
	public List<MedicineModel> findByName(String medName) {
		// TODO Auto-generated method stub
		return medRepo.findAll();
	}

	@Override
	public void insertMedicine(MedicineModel medicine) {
		// TODO Auto-generated method stub
		medRepo.save(medicine);
		System.out.println("New medicine added!");
	}

	@Override
	public void updateMedicine(int medId) {
		// TODO Auto-generated method stub
		   Optional<MedicineModel> med = medRepo.findById(medId);
		   	   
		   if(med==null) {
		    	System.out.println("Medicine not found");
		    }

		    if(med.isPresent()) {
		    MedicineModel medicine = med.get();
		    
		    Set<String> newIngredients = medicine.getIngredients();
		    newIngredients.add("ingredients111");
		    medicine.setIngredients(newIngredients);
		    
		    medicine.setMg(12.99);
		    medicine.setName("name2");
		    
		    Set<String> newSideEffects = medicine.getSideEffects();
		    newSideEffects.add("sideeffects");
		    medicine.setSideEffects(newSideEffects);
		    
		    //append pharmacy
		    List<PharmacyModel> pharmacies = medicine.getPharmacies();
		    
		    Optional<PharmacyModel> pharma = pharmaRepo.findById(101);//dummy
		     if(pharma.isPresent()) {
		    	 pharmacies.add(pharma.get());
		     }
		     
		    medicine.setPharmacies(pharmacies);
		    medRepo.save(medicine);
		    
		    System.out.println("Medicine updated");
		    }
	}

	@Override
	public void deleteMedicine(int medId) {
		// TODO Auto-generated method stub
	    medRepo.delete(medRepo.findById(medId).get());
	}
		
}
