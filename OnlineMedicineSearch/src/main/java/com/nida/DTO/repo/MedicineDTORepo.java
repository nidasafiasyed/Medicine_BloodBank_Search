package com.nida.DTO.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.DTO.MedicineSearchDTO;
import com.nida.model.Medicine;


@Repository
public interface MedicineDTORepo extends JpaRepository<Medicine, Integer>{
	
	@Query("SELECT new com.nida.DTO.MedicineSearchDTO(m.name, m.mg, p.name, p.address, p.is24hrs, p.delivery) "
			+ "FROM Medicine m INNER JOIN m.pharmacies p")
	List<MedicineSearchDTO> searchByName(String name, List<String> zip);

}
