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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	 
	  @PutMapping("/addMedicine/{id}") 
	  public Pharmacy addMedicine(@PathVariable(value="id") int pharmaId, @RequestParam(value = "medicineId") int medId) {
		  log.info("User requesting adding medicine to pharmacy");
		  return pharmacyService.insertMedicine(pharmaId, medId);
	  }

}
