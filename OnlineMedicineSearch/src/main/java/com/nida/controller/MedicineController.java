package com.nida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.model.Medicine;
import com.nida.service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService medserv;
	
	@GetMapping("/getMedicines")
	public List<Medicine> getAllMedicines(){
		return medserv.findAll();
	}

}
