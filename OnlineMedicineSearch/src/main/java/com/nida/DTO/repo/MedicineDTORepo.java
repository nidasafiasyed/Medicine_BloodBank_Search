package com.nida.DTO.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.model.Medicine;

@Repository
public interface MedicineDTORepo extends JpaRepository<Medicine, Integer>{
	
	@Query(
			  value = "SELECT * FROM medicines WHERE medicine_id = ?1", 
			  nativeQuery = true)
	Medicine findById(int id);
	
	@Query(
			  value = "SELECT * FROM medicines WHERE name LIKE %?1%", 
			  nativeQuery = true)
	List<Medicine> findByName(String name);

}
