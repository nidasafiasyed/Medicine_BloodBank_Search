package com.nida.service.impl;

import java.util.List;
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
import com.nida.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineRepo medicineRepo;
	
	@Autowired
	private PharmacyRepo pharmacyRepo;
	
	static Logger log = Logger.getLogger(MedicineServiceImpl.class.getName());

	@Override
	public List<Medicine> findAllMedicines() {
		// TODO Auto-generated method stub
		
		List<Medicine> medicines = medicineRepo.findAll();
		if(medicines.isEmpty()) {
			log.info("Empty medicine list");
			throw new MedicineNotFoundException();
		}
		else {
			log.info("Found all medicines");
			return medicines;
		}
		
	}
	
	@Override
	public Optional<Medicine> findMedicineById(int id) {
		if(medicineRepo.existsById(id)) {
			log.info("Found medicine with ID "+id);
			return medicineRepo.findById(id);
		}
		
		else {
			log.info("Medicine with "+id+" not found");
			throw new MedicineNotFoundException(id);
		}
	}

	@Override
	public Medicine insertMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		log.info("Added medicine with ID "+medicine.getMedId());
		return medicineRepo.save(medicine);
	}

	@Override
	public Medicine updateMedicine(int medId, Medicine medicine) {
		// TODO Auto-generated method stub
		
		  if(medicineRepo.existsById(medId)) {
			  Medicine med = medicineRepo.findById(medId).get();
			  
			   if(medicine.getName()!=null) {
				   med.setName(medicine.getName());
				   log.info("Updated medicine name "+medId+" to "+medicine.getName());
			   }
			   
			   if(medicine.getMg()!=null) {
				   med.setMg(medicine.getMg());
				   log.info("Updated medicine dosage "+medId+" to "+medicine.getMg());
			   }
			  
			  if(!medicine.getIngredients().isEmpty()) {
				  Set<String> ing = med.getIngredients();
				  ing.addAll(medicine.getIngredients());
				  med.setIngredients(ing); 
				  log.info("Updated medicine ingredients "+medId+" with "+medicine.getIngredients());
			  }
			  
			  if(!medicine.getSideEffects().isEmpty()) {
				  Set<String> se = med.getSideEffects();
				  se.addAll(medicine.getSideEffects());
				  med.setSideEffects(se);  
				  log.info("Updated medicine side effects "+medId+" with "+medicine.getSideEffects());
			  }
			  
			  return medicineRepo.save(med);
		  }
		  else {
		  log.info("Medicine with ID "+medId+" not found");
		  throw new MedicineNotFoundException(medId);
		  }
		 
	}

	@Override
	public void deleteMedicine(int medId) {
		// TODO Auto-generated method stub
		if(medicineRepo.existsById(medId)) {
			medicineRepo.deleteById(medId);
			log.info("Medicine with "+medId+" deleted");
		}
		
		else {
			log.info("Medicine with "+medId+" not found");
			throw new MedicineNotFoundException(medId);
		}
	}

	@Override
	public Medicine insertPharmacy(int medId, int pharmaId) {
		// TODO Auto-generated method stub
		
		  if(!medicineRepo.existsById(medId)) {
			 throw new MedicineNotFoundException(medId);
		  }
		
		  if(!pharmacyRepo.existsById(pharmaId)) {
				 throw new PharmacyNotFoundException(pharmaId);
		  }
		  
		  Medicine med = medicineRepo.findById(medId).get();
	      Pharmacy pharma = pharmacyRepo.findById(pharmaId).get();
	      
	     Set<Pharmacy> ph = med.getPharmacies();
	     ph.add(pharma);
	     med.setPharmacies(ph); 
	     log.info("Added pharmacy "+ pharmaId +" to medicine "+medId);
	     
	     return medicineRepo.save(med);
	
	}
		
}
