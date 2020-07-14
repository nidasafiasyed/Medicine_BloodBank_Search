package com.nida.DTO.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.DTO.MedicineSearchDTO;
import com.nida.model.Medicine;


@Repository
public interface MedicineDTORepo extends JpaRepository<Medicine, Integer>{
	
	@Query("SELECT new com.nida.DTO.MedicineSearchDTO(m.name, m.mg, p.name, p.street, p.city, p.state, p.zipcode, p.is24hrs, p.delivery) "
			+ "FROM Medicine m INNER JOIN m.pharmacies p "
			+ "WHERE m.name LIKE %?1% AND "
			+ "p.zipcode IN ?2")
	List<MedicineSearchDTO> searchByName(String name, List<Integer> zip);

}
