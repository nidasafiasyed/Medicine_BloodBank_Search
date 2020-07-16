package com.nida.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.model.Blood;
import com.nida.model.BloodBank;
import com.nida.service.BloodBankService;



@RestController
@RequestMapping("/bloodbank")
public class BloodBankController {
	
	static Logger log = Logger.getLogger(BloodBankController.class.getName());
	
	@Autowired
	BloodBankService bloodBankService;
	
	@GetMapping("/getBloodBanks") 
	public List<BloodBank> getAllBloodBanks() {
		log.info("User requesting all blood banks");
		return bloodBankService.findAllBloodBanks();
	  }
	
	  
	@GetMapping("/getBloodBankID/{id}")
	public BloodBank getBloodBankById(@PathVariable(value = "id") int bbId) {
		log.info("User requesting blood bank search by ID");
		return bloodBankService.findBloodBankById(bbId);
	}
	
	@PostMapping("/addBloodBank")
	public BloodBank addBloodBank(@Valid @RequestBody BloodBank bloodBank) {
		log.info("\"User requesting addition of blood bank");
		return bloodBankService.insertBloodBank(bloodBank);
	}
	
	@PutMapping("/updateBloodBank/{id}")
	public BloodBank updateBloodBank(@PathVariable(value="id") int bbId, @Valid @RequestBody BloodBank bloodBank) {
		log.info("User requesting updating blood bank");
		return bloodBankService.updateBloodBank(bbId, bloodBank);
	}
	
	@DeleteMapping("/removeBloodBank/{id}")
	public void deleteBloodBank(@PathVariable(value = "id") int bbId) {
		log.info("User requesting deletion of blood bank");
		bloodBankService.deleteBloodBank(bbId);
	}
	
	@PutMapping("/addBlood/{id}")
	public BloodBank addBlood(@PathVariable(value="id") int bbId, @RequestBody Blood blood) {
		log.info("User requesting adding blood to blood bank");
		return bloodBankService.addBloodToBloodBank(bbId, blood);
	}

}
