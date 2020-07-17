package com.nida.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nida.model.Blood;
import com.nida.model.BloodType;

@Repository
public interface BloodRepo extends JpaRepository<Blood, Integer>{
	
	@Query("SELECT b FROM Blood b WHERE b.type = ?1")
	List<Blood> findBloodByType(BloodType type);


}
