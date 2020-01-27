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
//@RequestMapping(path = "/api/CvBuilder")
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/users")
	public Personne register(@RequestBody RegisterForm userForm) {

		if (!userForm.getPassword().equals(userForm.getRepassword()))
			throw new RuntimeException("You must confirm your password");

		Personne userToFind = accountService.findUserByUsername(userForm.getUsername());
		if (userToFind != null)
			throw new RuntimeException("This user already exists");

		Personne user = new Personne();
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		accountService.saveUser(user);
		accountService.addRoleToUser(userForm.getUsername(), "USER");
		return user;
	}
}
