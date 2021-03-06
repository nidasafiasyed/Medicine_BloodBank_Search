package com.nida.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.model.Blood;
import com.nida.model.BloodType;
import com.nida.service.BloodService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/blood")
public class BloodController {
	
	static Logger log = Logger.getLogger(BloodController.class.getName());
	
	@Autowired
	BloodService bloodService;
	
	@GetMapping("/getAllBloodTypes")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Blood> getAllBloodTypes(){
		log.info("User requesting all blood types");
		return bloodService.findAllBlood();
		
	}
	
	@GetMapping("/getBloodType/{type}")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Blood> getBloodById(@PathVariable(value = "type") BloodType type) {
		log.info("User requesting blood type by ID");
		return bloodService.findBloodByType(type);
	}
	
	
	@PutMapping("/addBlood/{id}")
	@PreAuthorize("hasRole('BLOOD_BANK_MEMBER')")
	public Blood addBlood(@PathVariable(value="id") int bbId, @RequestBody Blood blood) {
		log.info("User requesting adding blood to blood bank");
		return bloodService.updateBlood(bbId, blood);
	}

}
