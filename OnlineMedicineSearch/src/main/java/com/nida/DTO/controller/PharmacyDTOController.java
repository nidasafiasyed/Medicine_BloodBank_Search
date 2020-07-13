package com.nida.DTO.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.DTO.PharmacyDTO;
import com.nida.model.Pharmacy;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyDTOController {
	
	static Logger log = Logger.getLogger(PharmacyDTOController.class.getName());
	
	@Autowired
	PharmacyDTO pharmacyDTO;
	
	@GetMapping("/getPharmacyID/{id}")
	public Pharmacy getPharmacyById(@PathVariable(value = "id") int pharmaId) {
	  log.info("User requesting pharmacy search by ID");
		return pharmacyDTO.findPharmacyById(pharmaId);
	}
  
	
	  @GetMapping("/getPharmacyName/{name}") public List<Pharmacy>
	  getPharmacyByName(@PathVariable(value = "name") String pharmaName)
	  { 
		  log.info("User requesting pharmacy search by name");
		  return pharmacyDTO.findPharmacyByName(pharmaName); 
		  }
	  
	  @GetMapping("/getPharmacyAddress/{zipcode}") public List<Pharmacy>
	  getPharmacyByAddress(@PathVariable(value = "zipcode") int zip)
	  { 
		  log.info("User requesting pharmacy search by zipcode");
		  return pharmacyDTO.findPharmacyByAddress(zip); 
		  }
	 

}
