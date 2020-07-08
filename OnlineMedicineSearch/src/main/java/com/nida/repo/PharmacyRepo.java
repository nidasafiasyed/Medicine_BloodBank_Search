package com.nida.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nida.model.PharmacyModel;

public interface PharmacyRepo extends JpaRepository<PharmacyModel, Integer>{

}
