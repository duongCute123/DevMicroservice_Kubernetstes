package spring.manager.user.service;

import java.util.List;

import spring.manager.user.entity.User;

public interface UserService {
	public List<User> findAllUser();

	public void addUser(User user);
}
