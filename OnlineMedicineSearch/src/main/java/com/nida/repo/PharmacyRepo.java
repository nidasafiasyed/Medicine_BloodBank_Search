package com.nida.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nida.model.Pharmacy;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer>{
	
	
	List<Pharmacy> findByName(String name);
	
	
	List<Pharmacy> findByAddress(int zip);
	
}
