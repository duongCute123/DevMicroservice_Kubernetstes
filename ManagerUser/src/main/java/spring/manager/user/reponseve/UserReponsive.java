package spring.manager.user.reponseve;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.manager.user.entity.User;

public interface UserReponsive extends JpaRepository<User, Integer> {

}
