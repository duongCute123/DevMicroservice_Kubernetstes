package spring.manager.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.manager.user.entity.User;
import spring.manager.user.reponseve.UserReponsive;

@Service
public class UserServiceImlp implements UserService {
	@Autowired
	UserReponsive userReponsive;

	@Override
	public List<User> findAllUser() {
		List<User> users=new ArrayList<>();
		users=userReponsive.findAll();
		return users;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userReponsive.save(user);
	}
}
