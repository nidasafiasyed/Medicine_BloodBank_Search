package com.nida.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nida.model.MedicineModel;

public interface MedicineRepo extends JpaRepository<MedicineModel, Integer>{

}
