package com.cvbuilder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Crypter le mot de passe
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // Désactive la création du synchronized tokken
		// http.formLogin().loginPage("/login"); Pas de formulaire d'authentification
		// mvc généré par spring, l'authentification se fera grace au front-end avec
		// Angular
		//Pas la
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/login/**", "/users/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/personnes/**","/users/").hasAnyAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
