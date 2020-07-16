package com.nida.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.model.Blood;
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
	public Blood getBloodById(@PathVariable(value = "id") int bId) {
		log.info("User requesting blood type by ID");
		return bloodService.findBloodById(bId);
	}
	
	@PostMapping("/addBlood")
	public Blood addBlood(@Valid @RequestBody Blood blood) {
		log.info("Adding new blood type to DB "+blood.getType());
		return bloodService.insertBlood(blood);
	}
	
	@DeleteMapping("/deleteBlood/{id}")
	public void deleteBlood(@PathVariable(value = "id") int bId) {
		log.info("Deleted  blood type with ID"+bId);
		bloodService.deleteBlood(bId);
	}

}
