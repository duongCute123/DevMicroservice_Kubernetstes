package spring.authen.jwt.reponse;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.authen.jwt.entity.ERole;
import spring.authen.jwt.entity.Role;


public interface RoleReponsitory extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERole name);
}

