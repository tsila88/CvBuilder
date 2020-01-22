package com.cvbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvbuilder.dao.PersonneRepository;
import com.cvbuilder.dao.RoleRepository;
import com.cvbuilder.entities.Personne;
import com.cvbuilder.entities.Role;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private PersonneRepository personneRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Personne saveUser(Personne personne) {
		String hashPassword = bCryptPasswordEncoder.encode(personne.getPassword());
		personne.setPassword(hashPassword);
		return personneRepository.save(personne);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Role role = roleRepository.findByRole(roleName);
		Personne personne = personneRepository.findByUserName(username);
		personne.getRoles().add(role);

	}

	@Override
	public Personne findUserByName(String name) {
		return personneRepository.findByUserName(name);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

}
