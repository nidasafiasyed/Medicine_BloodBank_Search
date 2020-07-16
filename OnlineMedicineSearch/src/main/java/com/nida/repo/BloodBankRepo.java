package com.nida.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nida.model.BloodBank;

@Repository
public interface BloodBankRepo extends JpaRepository<BloodBank, Integer>{

}
