package com.nida.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bloodbank")
public class BloodBankController {
	
	static Logger log = Logger.getLogger(BloodBankController.class.getName());

}
