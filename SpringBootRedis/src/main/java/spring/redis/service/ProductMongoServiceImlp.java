package spring.redis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.redis.entity.Product;
import spring.redis.reponse.ProductMongoReponse;

@Service
public class ProductMongoServiceImlp implements ProductMongoService {
	@Autowired
	ProductMongoReponse productMongoReponse;
	@Autowired
	public ProductMongoServiceImlp(ProductMongoReponse theMongoReponse) {
		productMongoReponse=theMongoReponse;
	}
	@Override
	public List<Product> findAll() {
		List<Product> list=new ArrayList<>();
		list=productMongoReponse.findAll();
		return list;
	}
	@Override
	public Product findByID(int id) {
		// TODO Auto-generated method stub
		return productMongoReponse.findById(id).orElse(null);
	}
	@Override
	public void addProduct(Product product) {
		productMongoReponse.save(product);
		
	}
	@Override
	public void deleteProduct(int id) {
		productMongoReponse.deleteById(id);
		
	}
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
}
