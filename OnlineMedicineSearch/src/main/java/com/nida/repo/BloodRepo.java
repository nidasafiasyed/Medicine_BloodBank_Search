package com.nida.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nida.model.Blood;

@Repository
public interface BloodRepo extends JpaRepository<Blood, Integer>{

}
