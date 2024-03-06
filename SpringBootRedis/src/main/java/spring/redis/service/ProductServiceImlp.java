package spring.redis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.redis.entity.Product;
import spring.redis.reponse.ProductReponsetory;

@Service
public class ProductServiceImlp implements ProductService {
	@Autowired
	ProductReponsetory productReponsetory;

	@Autowired
	public ProductServiceImlp(ProductReponsetory theProductReponsetory) {
		productReponsetory = theProductReponsetory;
	}

	@Override
	public List<Product> findAll() {
		List<Product> list = new ArrayList<>();
		list = productReponsetory.findAll();
		return list;
	}

	@Override
	public Product findByID(int id) {
		Optional<Product> optional = productReponsetory.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			new RuntimeException("Không có id cần tìm");
		}
		return product;
	}

	@Override
	public void addProduct(Product product) {
		productReponsetory.save(product);

	}

	@Override
	public void deleteProduct(int id) {
		productReponsetory.deleteById(id);

	}

	@Override
	public void updateProduct(Product product) {
		productReponsetory.save(product);

	}
}
