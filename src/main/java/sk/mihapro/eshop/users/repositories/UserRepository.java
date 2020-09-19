package sk.mihapro.eshop.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.mihapro.eshop.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
