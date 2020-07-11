package com.nida.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.model.Pharmacy;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer>{
	
	@Query("SELECT p FROM Pharmacy p WHERE p.name LIKE %?1%")
	List<Pharmacy> findByName(String name);
	
	List<Pharmacy> findByAddress(String zip);

}
