package sk.mihapro.eshop.users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.mihapro.eshop.users.entities.Role;

/**
 * JPA repository interface for Role objects
 * @author haska
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	/*
	 * Finds role in roles table
	 */
	Optional<Role> findByRole (String role);
}
