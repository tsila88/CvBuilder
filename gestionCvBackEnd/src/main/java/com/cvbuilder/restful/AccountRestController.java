package com.cvbuilder.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvbuilder.entities.Personne;
import com.cvbuilder.service.AccountService;

@RestController
@CrossOrigin(maxAge = 360)
@RequestMapping(path = "/api/CvBuilder")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public Personne register(@RequestBody RegisterForm userForm) {

		if (!userForm.getPassword().equals(userForm.getRepassword()))
			throw new RuntimeException("You must confirm your password");

		Personne personneToFind = accountService.findUserByName(userForm.getUserName());
		if (personneToFind != null)
			throw new RuntimeException("This user already exists");

		Personne personne = new Personne();
		personne.setUserName(userForm.getUserName());
		personne.setPassword(userForm.getPassword());
		accountService.saveUser(personne);
		accountService.addRoleToUser(userForm.getUserName(), "USER");
		return personne;
	}
}
