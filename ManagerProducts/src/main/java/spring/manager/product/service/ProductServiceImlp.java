package spring.manager.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.manager.product.entity.Product;
import spring.manager.product.reponsitory.ProductReponsitory;

@Service
public class ProductServiceImlp implements ProductService {
	@Autowired
	ProductReponsitory productReponsitory;

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		products = productReponsitory.findAll();
		return products;
	}

	@Override
	public void addProducts(Product product) {
		productReponsitory.save(product);

	}
}
