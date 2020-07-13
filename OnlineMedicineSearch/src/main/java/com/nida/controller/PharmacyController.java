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

import com.nida.OnlineMedicineSearchApplication;
import com.nida.model.Pharmacy;
import com.nida.service.PharmacyService;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {
	
	static Logger log = Logger.getLogger(PharmacyController.class.getName());
	 @Autowired
	 private PharmacyService pharmacyService;
	
	  @GetMapping("/getPharmacies") 
	  public List<Pharmacy> getAllPharmacies() {
		  log.info("User requesting all pharmacies");
		  return pharmacyService.findAllPharmacies();
	  }
	  

	  @PostMapping("/addPharmacy") 
	  public Pharmacy addPharmacy(@Valid @RequestBody Pharmacy pharmacy) {
		  log.info("User requesting addition of pharmacy");
		  return pharmacyService.insertPharmacy(pharmacy);
	  }
	  
	  
	  @GetMapping("/getPharmacyID/{id}")
		public Pharmacy getPharmacyById(@PathVariable(value = "id") int pharmaId) {
		  log.info("User requesting pharmacy search by ID");
			return pharmacyService.findPharmacyById(pharmaId);
		}
	  
		
		  @GetMapping("/getPharmacyName/{name}") public List<Pharmacy>
		  getPharmacyByName(@PathVariable(value = "name") String pharmaName)
		  { 
			  log.info("User requesting pharmacy search by name");
			  return pharmacyService.findPharmacyByName(pharmaName); 
			  }
		  
		  @GetMapping("/getPharmacyAddress/{zipcode}") public List<Pharmacy>
		  getPharmacyByAddress(@PathVariable(value = "zipcode") int zip)
		  { 
			  log.info("User requesting pharmacy search by zipcode");
			  return pharmacyService.findPharmacyByAddress(zip); 
			  }
		 
	  
	  @PutMapping("/updatePharmacy/{id}")
	  public Pharmacy updatePharmacy(@PathVariable(value="id") int pharmaId, @Valid @RequestBody Pharmacy pharmacy) {
		  log.info("User requesting updating pharmacy");
		return pharmacyService.updatePharmacy(pharmaId, pharmacy);
	  }
	  
	  @DeleteMapping("/removePharmacy/{id}")
		public void deletePharmacy(@PathVariable(value = "id") int pharmaId) {
		  log.info("User requesting deletion of pharmacy");
			pharmacyService.deletePharmacy(pharmaId);				
		}
	 

}
