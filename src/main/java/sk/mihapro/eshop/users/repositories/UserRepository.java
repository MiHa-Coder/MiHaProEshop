package sk.mihapro.eshop.users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.mihapro.eshop.users.entities.User;

/**
 * JPA repository interface for User objects
 * @author haska
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/*
	 * Finds user in users table by email
	 */
	Optional<User> findByEmail(String email);

}