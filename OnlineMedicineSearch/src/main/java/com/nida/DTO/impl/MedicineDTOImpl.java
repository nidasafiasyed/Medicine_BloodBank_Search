package com.nida.DTO.impl;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nida.DTO.MedicineSearch;
import com.nida.DTO.repo.MedicineDTORepo;
import com.nida.exception.MedicineNotFoundException;
import com.nida.model.Medicine;

@Service
public class MedicineDTOImpl implements MedicineSearch {

	static Logger log = Logger.getLogger(MedicineDTOImpl.class.getName());
	
	@Autowired
	MedicineDTORepo medicineRepo;

	@Override
	public List<Medicine> findMedicineByName(String name, int zip) {
		// TODO Auto-generated method stub
		int zipnearby[] = {zip-2, zip-1, zip, zip+1, zip+2};
		List<String> zipArray = Arrays.asList((Arrays.stream(zipnearby)
				.mapToObj(String::valueOf))
				.toArray(String[]::new));
		List<Medicine> medicines = medicineRepo.findByName(name, zipArray);
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
