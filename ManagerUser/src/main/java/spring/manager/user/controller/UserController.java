package spring.manager.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.manager.user.entity.User;
import spring.manager.user.reponseve.UserReponsive;
import spring.manager.user.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserReponsive userReponsive;

	// Lấy danh sách user
	@GetMapping("/user")
	public List<User> getAllUser() {
		List<User> listUser = new ArrayList<>();
		listUser = userService.findAllUser();
		return listUser;
	}

	// Thêm người dùng vào nhé
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		userService.addUser(user);
		return user;
	}

	// Tim thong tin theo id
	@GetMapping("/user/{id}")
	public User findByIdUser(@PathVariable Integer id) {
		Optional<User> optional = userReponsive.findById(id);
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			new RuntimeException("Khong co user theo id này");
		}

		return user;
	}
}
