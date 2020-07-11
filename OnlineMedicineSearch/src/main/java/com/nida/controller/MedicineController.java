package com.nida.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nida.model.Medicine;

import com.nida.service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
	

	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/getMedicines")
	public List<Medicine> getAllMedicines(){
		return medicineService.findAllMedicines();
	}
	
	@GetMapping("/getMedicineID/{id}")
	public Medicine getMedicineById(@PathVariable(value = "id") int medId) {
		return medicineService.findMedicineById(medId);	
	}
	
	@GetMapping("getMedicineName/{name}")
	public List<Medicine> getMedicineByName(@PathVariable(value = "name") String medName){
		return medicineService.findMedicineByName(medName);
	}
	
	  @PostMapping("/addMedicine") 
	  public Medicine addMedicine(@Valid @RequestBody Medicine medicine) {
		  return medicineService.insertMedicine(medicine);
	  }
	  
	  @PutMapping("/updateMedicine/{id}")
	  public Medicine updateMedicine(@PathVariable(value="id") int medId, @Valid @RequestBody Medicine medicine) {
		  return medicineService.updateMedicine(medId, medicine);
	  }
	  
	  @DeleteMapping("/removeMedicine/{id}")
		public void deleteMedicine(@PathVariable(value = "id") int medId) {
			medicineService.deleteMedicine(medId);
				
		}

}
