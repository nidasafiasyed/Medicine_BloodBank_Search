package com.nida.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nida.model.Medicine;
import com.nida.service.MedicineService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/medicine")
public class MedicineController {
	
	static Logger log = Logger.getLogger(MedicineController.class.getName());

	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/getAllMedicines")
	@PreAuthorize("hasRole('MEDICAL_MEMBER') or hasRole('ADMIN')")
	public List<Medicine> getAllMedicines(){
		log.info("User requesting all medicines");
		return medicineService.findAllMedicines();
		
	}
	
	@GetMapping("/getMedicineID/{id}")
	@PreAuthorize("hasRole('MEDICAL_MEMBER') or hasRole('ADMIN')")
	public Optional<Medicine> getMedicineById(@PathVariable(value = "id") int medId) {
		log.info("User requesting medicine search by ID");
		return medicineService.findMedicineById(medId);
	}
	
	  @PostMapping("/addMedicine")
	  @PreAuthorize("hasRole('MEDICAL_MEMBER')")
	  public Medicine addMedicine(@RequestBody Medicine medicine) {
		  log.info("User requesting medicine creation");
		  return medicineService.insertMedicine(medicine);
	  }
	  
	  @PutMapping("/updateMedicine/{id}")
	  @PreAuthorize("hasRole('MEDICAL_MEMBER')")
	  public Medicine updateMedicine(@PathVariable(value="id") int medId, @RequestBody Medicine medicine) {
		  log.info("User requesting medicine editing");
		  return medicineService.updateMedicine(medId, medicine);
	  }
	  
	  @DeleteMapping("/removeMedicine/{id}")
	  @PreAuthorize("hasRole('ADMIN')")
		public void deleteMedicine(@PathVariable(value = "id") int medId) {
		  log.info("User requesting medicine deletion");
			medicineService.deleteMedicine(medId);
				
		}
	  
	  @PutMapping("/addPharmacy/{id}")
	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	  public Medicine addPharmacy(@PathVariable(value="id") int medId, @RequestParam(value = "pId") int pharmaId) {
		  log.info("User requesting adding pharmacy to medicine");
		  return medicineService.insertPharmacy(medId, pharmaId);
	  }

}
