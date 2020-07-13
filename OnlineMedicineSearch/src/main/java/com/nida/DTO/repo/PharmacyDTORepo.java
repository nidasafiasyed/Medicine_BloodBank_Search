package com.nida.DTO.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.model.Pharmacy;

@Repository
public interface PharmacyDTORepo extends JpaRepository<Pharmacy, Integer>{
	
	@Query(
			  value = "SELECT * FROM pharmacies WHERE name LIKE %?1%", 
			  nativeQuery = true)
	List<Pharmacy> findByName(String name, List<String> zip);
	
	@Query(
			  value = "SELECT * FROM pharmacies WHERE address->>'$.zipcode' IN ?1", 
			  nativeQuery = true)
	 List<Pharmacy> findByAddress(List<String> zip);
	

}
