package spring.manager.product.reponsitory;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import spring.manager.product.entity.Product;
@Repository
public class ProductRedisReponse {
	private HashOperations hashOperations;
	private RedisTemplate redisTemplate;

	 public ProductRedisReponse(RedisTemplate redisTemplate) {
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
