package com.cvbuilder.service;

import com.cvbuilder.entities.Personne;
import com.cvbuilder.entities.Role;

public interface AccountService {

	public Personne saveUser(Personne user);

	public Role saveRole(Role role);

	public void addRoleToUser(String username, String roleName);
	
	public Personne findUserByUsername(String username);

	

}
