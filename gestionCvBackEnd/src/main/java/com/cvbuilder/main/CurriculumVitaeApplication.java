package com.cvbuilder.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cvbuilder.entities.Personne;
import com.cvbuilder.entities.Role;
import com.cvbuilder.service.AccountService;

@EnableJpaRepositories(basePackages = { "com.cvbuilder.dao" })
@EntityScan(basePackages = { "com.cvbuilder.entities" })
@ComponentScan(basePackages = { "com.cvbuilder.restful","com.cvbuilder.security","com.cvbuilder.service" })
@SpringBootApplication
public class CurriculumVitaeApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	

	public static void main(String[] args) {
		SpringApplication.run(CurriculumVitaeApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountService.saveUser(new Personne(null,"admin","admin",null, null, null, null, null, null, null, null));
		accountService.saveUser(new Personne(null,"user","user",null, null, null, null, null, null, null, null));

		accountService.saveRole(new Role(null,"ADMIN"));
		accountService.saveRole(new Role(null,"USER"));
		
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		
	}
}
