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
import com.nida.model.Medicine;

import com.nida.service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
	
	static Logger log = Logger.getLogger(OnlineMedicineSearchApplication.class.getName());

	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/getMedicines")
	public List<Medicine> getAllMedicines(){
		log.info("User requesting all medicines");
		return medicineService.findAllMedicines();
		
	}
	
	@GetMapping("/getMedicineID/{id}")
	public Medicine getMedicineById(@PathVariable(value = "id") int medId) {
		log.info("User requesting medicine search by ID");
		return medicineService.findMedicineById(medId);	
	}
	
	@GetMapping("getMedicineName/{name}")
	public List<Medicine> getMedicineByName(@PathVariable(value = "name") String medName){
		log.info("User requesting medicine search by name");
		return medicineService.findMedicineByName(medName);
	}
	
	  @PostMapping("/addMedicine") 
	  public Medicine addMedicine(@Valid @RequestBody Medicine medicine) {
		  log.info("User requesting medicine creation");
		  return medicineService.insertMedicine(medicine);
	  }
	  
	  @PutMapping("/updateMedicine/{id}")
	  public Medicine updateMedicine(@PathVariable(value="id") int medId, @Valid @RequestBody Medicine medicine) {
		  log.info("User requesting medicine editing");
		  return medicineService.updateMedicine(medId, medicine);
	  }
	  
	  @DeleteMapping("/removeMedicine/{id}")
		public void deleteMedicine(@PathVariable(value = "id") int medId) {
		  log.info("User requesting medicine deletion");
			medicineService.deleteMedicine(medId);
				
		}

}
