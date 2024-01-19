package spring.authen.jwt.reponse;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring.authen.jwt.entity.User;
public interface UserReponsitory extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@Query("select u from User u where u.username= :username")
	public User timUserByName(String username);
}

