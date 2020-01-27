package com.cvbuilder.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

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
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		accountService.saveUser(new Personne(null,"admin","admin", null, null, null, null, null, null, null, null));
		accountService.saveUser(new Personne(null,"user","user", null, null, null, null, null, null, null, null));

		accountService.saveRole(new Role(null,"ADMIN"));
		accountService.saveRole(new Role(null,"USER"));
		
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		
		Fairy fairy = Fairy.create();

		
		/*for(int i = 0; i<10; i++) {
			Person personFairy = fairy.person();
			Personne contact = new Personne();
			contact.setNom(personFairy.getFirstName());
			contact.setUsername(personFairy.getUsername());
			contact.setPassword("user");
			contact.setPrenom(personFairy.getLastName());
			contact.setAdresse_electronique(personFairy.getEmail());
			contact.setDate_naissance(df.parse("12/02/1992"));
			contact.setSite_web(personFairy.getFullName());
			accountService.saveUser(contact);
			accountService.addRoleToUser(personFairy.getUsername(), "USER");
		}*/
		
	}
}
