package com.nida.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nida.model.Pharmacy;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer>{

}
