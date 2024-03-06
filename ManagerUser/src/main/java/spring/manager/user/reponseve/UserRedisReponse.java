package spring.manager.user.reponseve;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import spring.manager.user.entity.User;

@Repository
public class UserRedisReponse {
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;

	public UserRedisReponse(RedisTemplate redisTemplate) {
		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}

	public void saveUser(User user) {
		hashOperations.put("USER", user.getId(), user);
	}

	public List<User> findAll() {
		return hashOperations.values("USER");
	}

	public User getById(int id) {
		return (User) hashOperations.get("USER", id);
	}
}
