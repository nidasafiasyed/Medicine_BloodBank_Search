package com.nida.DTO.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nida.DTO.BloodSearchDTO;
import com.nida.DTO.service.BloodDTOService;
import com.nida.model.BloodType;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/search")
public class BloodDTOController {
	
	static Logger log = Logger.getLogger(BloodDTOController.class.getName());
	
	@Autowired
	BloodDTOService bloodService;
	
	@GetMapping("getBloodType/{type}")
	public List<BloodSearchDTO> getBloodByType(@PathVariable(value = "type") BloodType type, @RequestParam(value = "zip") int zip){
		log.info("User requesting blood search by type");
		return bloodService.searchBlood(type, zip);
	}

}
