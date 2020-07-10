package com.nida.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nida.model.Pharmacy;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer>{

}
