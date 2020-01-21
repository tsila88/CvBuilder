package com.cvbuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvbuilder.entities.AppRole;

public interface AppRoleRepository  extends JpaRepository<AppRole, Long>{
	public AppRole findByRole(String role);

}
