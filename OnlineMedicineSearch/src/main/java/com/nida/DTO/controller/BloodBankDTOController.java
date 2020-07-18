package com.nida.DTO.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nida.DTO.BloodBankSearchDTO;
import com.nida.DTO.service.BloodBankDTOService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/search")
public class BloodBankDTOController {
	
static Logger log = Logger.getLogger(BloodBankDTOController.class.getName());
	
	@Autowired
	BloodBankDTOService bloodBankService;
	
	@GetMapping("/getBloodBankName/{name}")
	public List<BloodBankSearchDTO> getBloodBankByName(@PathVariable(value = "name") String name, @RequestParam(value = "zip") int zip){
		log.info("User requesting blood bank search by name");
		return bloodBankService.searchBloodBank(name, zip);
	}


}
