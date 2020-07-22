package com.nida.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nida.security.model.User;
import com.nida.security.repo.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/details/{username}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('BLOOD_BANK_MEMBER') or hasRole('MEDICAL_MEMBER')")
	public User userAccess(@PathVariable("username") String username) {
		return userRepo.findByUsername(username);
	}

}
