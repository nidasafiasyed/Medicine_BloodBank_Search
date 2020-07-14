package com.nida.DTO.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.DTO.PharmacySearchDTO;
import com.nida.model.Pharmacy;

@Repository
public interface PharmacyDTORepo extends JpaRepository<Pharmacy, Integer>{
	
	@Query("SELECT new com.nida.DTO.PharmacySearchDTO(p.name, p.street, p.city, p.state, p.zipcode, p.is24hrs, p.delivery, m.name, m.mg) "
			+ "FROM Medicine m INNER JOIN m.pharmacies p "
			+ "WHERE p.name LIKE %?1% AND "
			+ "p.zipcode IN ?2")
	List<PharmacySearchDTO> searchByName(String name, List<Integer> zip);

}
