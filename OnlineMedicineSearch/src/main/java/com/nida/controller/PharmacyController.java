package com.nida.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.model.Pharmacy;
import com.nida.service.PharmacyService;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {
	
	static Logger log = Logger.getLogger(PharmacyController.class.getName());
	 @Autowired
	 private PharmacyService pharmacyService;
	
	  @GetMapping("/getAllPharmacies")
	  @PreAuthorize("hasRole('ADMIN')")
	  public List<Pharmacy> getAllPharmacies() {
		  log.info("User requesting all pharmacies");
		  return pharmacyService.findAllPharmacies();
	  }
	  
	  @GetMapping("/getPharmacyID/{id}")
	  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
		public Pharmacy getPharmacyById(@PathVariable(value = "id") int pharmaId) {
		  log.info("User requesting pharmacy search by ID");
			return pharmacyService.findPharmacyById(pharmaId);
		}
	  

	  @PostMapping("/addPharmacy")
	  @PreAuthorize("hasRole('ADMIN')")
	  public Pharmacy addPharmacy(@RequestBody Pharmacy pharmacy) {
		  log.info("User requesting addition of pharmacy");
		  return pharmacyService.insertPharmacy(pharmacy);
	  }
	  
	  @PutMapping("/updatePharmacy/{id}")
	  @PreAuthorize("hasRole('MEDICAL_MEMBER')")
	  public Pharmacy updatePharmacy(@PathVariable(value="id") int pharmaId, @RequestBody Pharmacy pharmacy) {
		  log.info("User requesting updating pharmacy");
		return pharmacyService.updatePharmacy(pharmaId, pharmacy);
	  }
	  
	  @DeleteMapping("/removePharmacy/{id}")
	  @PreAuthorize("hasRole('ADMIN')")
		public void deletePharmacy(@PathVariable(value = "id") int pharmaId) {
		  log.info("User requesting deletion of pharmacy");
			pharmacyService.deletePharmacy(pharmaId);				
		}
	 
	 

}
