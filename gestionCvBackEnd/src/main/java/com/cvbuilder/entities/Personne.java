package com.cvbuilder.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	//@JsonIgnore
	private String password;
	private String nom;
	
	private String prenom;
	private String adresse_electronique;
	private String site_web;
	private LocalDate date_naissance;
	private String texte_descriptif;
	@OneToOne(mappedBy = "personne", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
	private CurriculumVitae curriculumVitae;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<Role>();
}
