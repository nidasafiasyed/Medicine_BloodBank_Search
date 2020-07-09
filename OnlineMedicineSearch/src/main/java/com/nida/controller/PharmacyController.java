package com.nida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.model.Pharmacy;
import com.nida.service.PharmacyService;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {
	
	@Autowired
	private PharmacyService pharmaServ;
	
	@GetMapping("/getPharmacies")
	public List<Pharmacy> getAllPharmacies(){
		return pharmaServ.findAll();
	}
	
	@GetMapping("/getPharmacy")
	public List<Pharmacy> getPharmacy(){}

}
