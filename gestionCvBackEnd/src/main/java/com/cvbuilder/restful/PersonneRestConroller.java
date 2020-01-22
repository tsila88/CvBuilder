package com.cvbuilder.restful;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvbuilder.dao.PersonneRepository;
import com.cvbuilder.entities.Personne;

@RestController
@CrossOrigin(maxAge = 360)
@RequestMapping(path = "/api/CvBuilder")

public class PersonneRestConroller {

	Logger logger = LoggerFactory.getLogger(Personne.class);
	@Autowired
	private PersonneRepository personneRepository;

	@GetMapping("/personnes")
	public ResponseEntity<List<Personne>> findAllPersonnes() {
		List<Personne> listPersonnes = personneRepository.findAll();
		if (listPersonnes == null) {
			logger.info("The list of personnes is empty");
		} else {
			logger.info("The list of personnes contains personnes");
		}
		return ResponseEntity.ok().body(listPersonnes);

	}

	@GetMapping("/personnes/{idPersonne}")
	public ResponseEntity<Optional<Personne>> findPersonneById(@PathVariable Long idPersonne) {
		Optional<Personne> personneToFind = personneRepository.findById(idPersonne);
		if (!personneToFind.isPresent()) {
			logger.info("The personne with the id " + idPersonne + "  NOT FOUND ");
			return ResponseEntity.notFound().build();
		} else {
			logger.info("The personne with the id " + idPersonne + "  was FOUND ");
		}
		return ResponseEntity.ok().body(personneToFind);
	}

	@DeleteMapping("/personnes/{idPersonne}")
	public ResponseEntity<Object> deletePersonneById(@PathVariable Long idPersonne) {
		Optional<Personne> personneToFind = personneRepository.findById(idPersonne);
		if (!personneToFind.isPresent()) {
			logger.info("The personne with the id " + idPersonne + "  NOT FOUND ");
			return ResponseEntity.notFound().build();
		} else {
			logger.info("The personne with the id " + idPersonne + "  was FOUND ");
			personneRepository.deleteById(idPersonne);
			logger.info("The personne with the id " + idPersonne + "  was DELETED");
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/personnes")
	public ResponseEntity<Personne> updatePersonne(@RequestBody Personne personne) {
		Optional<Personne> personneToFind = personneRepository.findById(personne.getId());
		if (!personneToFind.isPresent()) {
			logger.info("The personne with the id " + personne.getId() + "  NOT FOUND ");
			return ResponseEntity.notFound().build();
		} else {
			logger.info("The personne with the id " + personne.getId() + "  was FOUND ");
		}
		personneToFind.get().setAdresse_electronique(personne.getAdresse_electronique());
		personneToFind.get().setCurriculumVitae(personne.getCurriculumVitae());
		personneToFind.get().setDate_naissance(personne.getDate_naissance());
		personneToFind.get().setNom(personne.getNom());
		personneToFind.get().setPrenom(personne.getPrenom());
		personneToFind.get().setSite_web(personne.getSite_web());
		personneToFind.get().setTexte_descriptif(personne.getTexte_descriptif());
		Personne updatedPersonne = personneRepository.save(personne);
		logger.info("The personne with the id " + personne.getId() + "  was UPDATED");
		return ResponseEntity.ok().body(updatedPersonne);
	}

	@PostMapping("/personnes")
	public ResponseEntity<Personne> addPersonne(@RequestBody Personne personne) {
		if (personne.getId() != null) {
			logger.info("The personne with the id " + personne.getId() + " already EXISTS ");
			return ResponseEntity.badRequest().build();
		}
		Personne addedPersonne = personneRepository.save(personne);
		logger.info("The personne with the id " + addedPersonne.getId() + "  was CREATED ");
		return ResponseEntity.ok().body(addedPersonne);
	}
}
