package com.cvbuilder.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages={"com.cvbuilder.dao"})
@EntityScan( basePackages = {"com.cvbuilder.entities"} )
@ComponentScan(basePackages = {"com.cvbuilder.restful"})
@SpringBootApplication
public class CurriculumVitaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurriculumVitaeApplication.class, args);
	}

}
