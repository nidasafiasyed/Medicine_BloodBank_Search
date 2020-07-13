package com.nida.DTO.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.DTO.MedicineDTO;
import com.nida.DTO.repo.MedicineDTORepo;
import com.nida.exception.MedicineNotFoundException;
import com.nida.model.Medicine;

@Service
public class MedicineDTOImpl implements MedicineDTO {

	static Logger log = Logger.getLogger(MedicineDTOImpl.class.getName());
	
	@Autowired
	MedicineDTORepo medicineRepo;
	
	@Override
	public Medicine findMedicineById(int id) {
		// TODO Auto-generated method stub
		Medicine medicine = medicineRepo.findById(id);
		if(medicine != null) {
			log.info("Found medicine with ID "+id);
			return medicine;
		}
		
		else {
			log.info("Medicine with "+id+" not found");
			throw new MedicineNotFoundException(id);
		}
	}

	@Override
	public List<Medicine> findMedicineByName(String name) {
		// TODO Auto-generated method stub
		List<Medicine> medicines = medicineRepo.findByName(name);
		if(medicines.isEmpty()) {
			log.info("Medicines with "+name+" not found");
			throw new MedicineNotFoundException(name);
		}
		else {
		log.info("Medicines with "+name+" found");
		return medicines;
		} 
	}

}
