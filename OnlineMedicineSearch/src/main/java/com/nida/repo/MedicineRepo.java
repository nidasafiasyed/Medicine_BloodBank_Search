package com.nida.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nida.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Integer>{

}
