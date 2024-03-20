package spring.redis.reponse;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import spring.redis.entity.Product;

@Repository
public class RedisReponse {
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;

	public RedisReponse(RedisTemplate redisTemplate) {
		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}

	public void saveProduct(Product product) {
		hashOperations.put("PRODUCT", product.getId(), product);
	}

	public List<Product> findAll() {
		return hashOperations.values("PRODUCT");
	}

	public Product getById(int id) {
		return (Product) hashOperations.get("PRODUCT", id);
	}

	public void updateProduct(Product product) {
		saveProduct(product);
	}

	public void deleteProduct(int id) {
		hashOperations.delete("PRODUCT", id);
	}
}
