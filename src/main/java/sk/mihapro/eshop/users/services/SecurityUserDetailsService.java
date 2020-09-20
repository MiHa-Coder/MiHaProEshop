package sk.mihapro.eshop.users.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sk.mihapro.eshop.users.entities.User;
import sk.mihapro.eshop.users.models.SecurityUserDetails;
import sk.mihapro.eshop.users.repositories.UserRepository;

/**
 * Finds user in database by email and returns users data in UserDetails type
 * @author haska
 *
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public SecurityUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/*
	 * Email is used as username
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		
		user.orElseThrow(() -> new UsernameNotFoundException("User with " + email +" Not Found."));
		return user.map(SecurityUserDetails::new).get();
	}
	
	
}
