package com.nida.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nida.model.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer>{

	List<Medicine> findByName(String name);
}
