package com.nida.DTO.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nida.DTO.MedicineSearch;
import com.nida.model.Medicine;

@RestController
@RequestMapping("/medicine")
public class MedicineDTOController {
	
	static Logger log = Logger.getLogger(MedicineDTOController.class.getName());
	
	@Autowired
	MedicineSearch medicineDTO;
	
	@GetMapping("getMedicineName/{name}")
	public List<Medicine> getMedicineByName(@PathVariable(value = "name") String medName, @RequestParam(value = "zip")int zip){
		log.info("User requesting medicine search by name");
		return medicineDTO.findMedicineByName(medName, zip);
	}

}
