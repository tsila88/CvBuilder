package com.cvbuilder.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
	private String nom;
	private String prenom;
	private String adresse_electronique;
	private String site_web;
	private LocalDate date_naissance;
	private String texte_descriptif;
	private String mot_de_passe;
	
	@OneToOne(mappedBy = "personne", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
	private CurriculumVitae curriculumVitae;

}
