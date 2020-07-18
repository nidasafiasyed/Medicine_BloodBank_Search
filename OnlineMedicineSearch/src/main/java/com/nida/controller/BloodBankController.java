package com.nida.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nida.model.BloodBank;
import com.nida.service.BloodBankService;
import com.nida.service.BloodService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bloodbank")
public class BloodBankController {
	
	static Logger log = Logger.getLogger(BloodBankController.class.getName());
	
	@Autowired
	BloodService bloodService;
	
	@Autowired
	BloodBankService bloodBankService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAllBloodBanks") 
	public List<BloodBank> getAllBloodBanks() {
		log.info("User requesting all blood banks");
		return bloodBankService.findAllBloodBanks();
	  }
	
	  
	@GetMapping("/getBloodBankID/{id}")
	@PreAuthorize("hasRole('BLOOD_BANK_MEMBER') or hasRole('ADMIN')")
	public BloodBank getBloodBankById(@PathVariable(value = "id") int bbId) {
		log.info("User requesting blood bank search by ID");
		return bloodBankService.findBloodBankById(bbId);
	}
	
	@PostMapping("/addBloodBank")
	@PreAuthorize("hasRole('ADMIN')")
	public BloodBank addBloodBank(@RequestBody BloodBank bloodBank) {
		log.info("User requesting addition of blood bank");
		return bloodBankService.insertBloodBank(bloodBank);
	}
	
	@PutMapping("/updateBloodBank/{id}")
	@PreAuthorize("hasRole('BLOOD_BANK_MEMBER')")
	public BloodBank updateBloodBank(@PathVariable(value="id") int bbId, @RequestBody BloodBank bloodBank) {
		log.info("User requesting updating blood bank");
		return bloodBankService.updateBloodBank(bbId, bloodBank);
	}
	
	@DeleteMapping("/removeBloodBank/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteBloodBank(@PathVariable(value = "id") int bbId) {
		log.info("User requesting deletion of blood bank");
		bloodBankService.deleteBloodBank(bbId);
	}

}
