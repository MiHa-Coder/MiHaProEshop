package sk.mihapro.eshop.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.mihapro.eshop.security.config.PasswordConfiguration;
import sk.mihapro.eshop.users.entities.Role;
import sk.mihapro.eshop.users.entities.User;
import sk.mihapro.eshop.users.enums.RoleTypes;
import sk.mihapro.eshop.users.repositories.UserRepository;

@Service
public class UserRegistrationService {

	private UserRepository userRepository;
	private PasswordConfiguration passwordEncoder;

	@Autowired
	public UserRegistrationService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	/*
	 * Adds new user to database
	 */
	public User addUser(User user) {
		
		User newUser = new User(); 
		Role newRole = new Role();
		
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.getPasswordEncoder().encode(user.getPassword()));
		newUser.setEnabled(true);
		newRole.setRole(RoleTypes.ROLE_USER.name());
		newUser.setAuthorities(newRole);
		
		return this.userRepository.save(newUser);
	}
	

	/*
	 * Returns all users
	 */
	public List<User> findAll(){
		return this.userRepository.findAll();
	}
}
