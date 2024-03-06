package spring.redis.service;

import java.util.List;

import spring.redis.entity.Product;

public interface ProductService {
	public List<Product> findAll();

	public Product findByID(int id);

	public void addProduct(Product product);

	public void deleteProduct(int id);

	public void updateProduct(Product product);
}
