package sk.mihapro.eshop.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sk.mihapro.eshop.users.entities.User;
import sk.mihapro.eshop.users.services.UserRegistrationService;

@RestController
@CrossOrigin
public class RegistrationController {

	private final UserRegistrationService userRegistrationService;

	@Autowired
	public RegistrationController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	/*
	 * Add new user to database
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/registration",
					consumes = "application/json")
	public User addUser(@Valid @NotNull @RequestBody User user) {
		System.out.println(user.getEmail());
		return this.userRegistrationService.addUser(user);
	}

	// test if user are in database -- to be deleted
	@RequestMapping("/registration")
	public List<User> getAllUsers() {
		return this.userRegistrationService.findAll();
	}
}
