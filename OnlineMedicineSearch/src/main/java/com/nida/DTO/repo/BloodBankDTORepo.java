package com.nida.DTO.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.DTO.BloodBankSearchDTO;

@Repository
public interface BloodBankDTORepo extends JpaRepository<BloodBankDTORepo, Integer>{
	
	@Query("SELECT new com.nida.DTO.BloodBankSearchDTO(bb.name, bb.street, bb.city, bb.state, bb.zipcode, b.type, b.units, bb.is24hrs) "
			+ "FROM bloodBank bb INNER JOIN bb.blood b "
			+ "WHERE bb.name LIKE %?1% AND "
			+ "bb.zipcode IN ?2")
	List<BloodBankSearchDTO> searchByName(String name, List<Integer> zip);
	

}
