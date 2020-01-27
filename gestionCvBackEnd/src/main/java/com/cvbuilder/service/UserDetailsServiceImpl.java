package com.cvbuilder.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cvbuilder.entities.Personne;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AccountService accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Personne personne = accountService.findUserByUsername(username);
		if (personne == null ) throw new UsernameNotFoundException(username);
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		personne.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		});
		return new User(personne.getUsername(),personne.getPassword(),authorities);
	}

}
