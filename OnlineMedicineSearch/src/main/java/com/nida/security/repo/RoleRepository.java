package com.nida.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nida.security.model.Role;
import com.nida.security.model.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByType(RoleType type);

}
