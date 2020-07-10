package com.nida.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.model.Medicine;
import com.nida.model.Pharmacy;
import com.nida.repo.MedicineRepo;
import com.nida.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineRepo medicineRepo;

	@Override
	public List<Medicine> findAllMedicines() {
		// TODO Auto-generated method stub
		return medicineRepo.findAll();
	}

	@Override
	public Medicine findMedicineById(int medId) {
		// TODO Auto-generated method stub
		Optional<Medicine> medicine = medicineRepo.findById(medId);
		if(medicine.isPresent()) {
			return medicine.get();
		}
		return null;
	}

	@Override
	public List<Medicine> findByName(String medName) {
		// TODO Auto-generated method stub
		return medicineRepo.findAll();
	}

	@Override
	public Medicine insertMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineRepo.save(medicine);
	}

	@Override
	public Medicine updateMedicine(int medId, Medicine medicine) {
		// TODO Auto-generated method stub
		Optional<Medicine> medornull = medicineRepo.findById(medId);
		  if(medornull.isPresent()) {
			  Medicine med = medornull.get();
			  
			  med.setMedId(medicine.getMedId());
			  med.setName(medicine.getName());
			  med.setMg(medicine.getMg());
			  
			  Set<String> ing = med.getIngredients();
			  ing.addAll(medicine.getIngredients());
			  med.setIngredients(ing);
			  
			  Set<String> se = med.getSideEffects();
			  se.addAll(medicine.getSideEffects());
			  med.setSideEffects(se);
			  
			  Set<Pharmacy> ph = med.getPharmacies();
			  ph.addAll(medicine.getPharmacies());
			  med.setPharmacies(ph);
			  return medicineRepo.save(med);
		  }
		  
		  return null;
	}

	@Override
	public void deleteMedicine(int medId) {
		// TODO Auto-generated method stub
		Optional<Medicine> medicine = medicineRepo.findById(medId);
		if(medicine.isPresent()) {
			medicineRepo.deleteById(medId);
		}
	}
		
}
