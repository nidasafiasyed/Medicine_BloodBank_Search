package com.nida.DTO.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.DTO.BloodSearchDTO;
import com.nida.model.Blood;
import com.nida.model.BloodType;

@Repository
public interface BloodDTORepo extends JpaRepository<Blood, Integer>{
	
	@Query("SELECT new com.nida.DTO.BloodSearchDTO(b.type, b.units, bb.name, bb.street, bb.city, bb.state, bb.zipcode, bb.is24hrs) "
			+ "FROM BloodBank bb JOIN bb.bloodList b "
			+ "WHERE b.type = ?1 AND "
			+ "bb.zipcode IN ?2")
	List<BloodSearchDTO> searchByName(BloodType type, List<Integer> zip);


}
