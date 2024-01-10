package spring.manager.product.service;

import java.util.List;

import spring.manager.product.entity.Product;

public interface ProductService {
	public List<Product> findAllProducts();

	public void addProducts(Product product);
}
