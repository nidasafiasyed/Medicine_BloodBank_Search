package com.nida.DTO.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nida.DTO.PharmacySearchDTO;
import com.nida.DTO.service.PharmacyDTOService;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyDTOController {
	
	static Logger log = Logger.getLogger(PharmacyDTOController.class.getName());
	
	@Autowired
	PharmacyDTOService pharmacyService;

	  @GetMapping("/getPharmacyName/{name}") 
	  public List<PharmacySearchDTO> getPharmacyByName(@PathVariable(value = "name") String pharmaName, @RequestParam(value = "zip") int zip)
	  { 
		  log.info("User requesting pharmacy search by name");
		  return pharmacyService.searchPharmacy(pharmaName, zip); 
		  }
	
}
