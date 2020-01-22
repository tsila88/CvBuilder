package com.cvbuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvbuilder.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{
	
	public Role findByRole(String role);

}
