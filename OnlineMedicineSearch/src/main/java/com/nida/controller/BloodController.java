package com.nida.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.model.Blood;
import com.nida.model.Medicine;
import com.nida.service.BloodService;

@RestController
@RequestMapping("/blood")
public class BloodController {
	
	static Logger log = Logger.getLogger(BloodController.class.getName());
	
	@Autowired
	BloodService bloodService;
	
	@GetMapping("/getAllBloodTypes")
	public List<Blood> getAllBloodTypes(){
		log.info("User requesting all blood types");
		return bloodService.findAllBlood();
		
	}
	
	@GetMapping("/getBID/{id}")
	public Medicine getMedicineById(@PathVariable(value = "id") int medId) {
		log.info("User requesting medicine search by ID");
		return medicineService.findMedicineById(medId);
	}

}
