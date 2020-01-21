package com.cvbuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvbuilder.entities.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
