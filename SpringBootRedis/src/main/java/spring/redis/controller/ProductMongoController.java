package spring.redis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.redis.entity.Product;
//import spring.redis.service.ProductMongoService;
import spring.redis.reponse.ProductMongoReponse;

@RestController
@RequestMapping("/api/v3")
public class ProductMongoController {
//	@Autowired
//	ProductMongoService productMongoService;
	@Autowired
	ProductMongoReponse productMongoReponse;

	@PostMapping("/product")
	public Product addProduc(@RequestBody Product product) {
		productMongoReponse.save(product);
		return product;
	}

	@GetMapping("/product")
	public List<Product> findAllProduct() {
		List<Product> list = new ArrayList<>();
		list = productMongoReponse.findAll();
		return list;
	}

	@GetMapping("/product/{id}")
	public Product getByID(@PathVariable int id) {
		Optional<Product> optional = productMongoReponse.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		}
		return product;
	}
	@DeleteMapping("/product/{id}")
	public String xoaProduct(@PathVariable int id) {
		productMongoReponse.deleteById(id);
		return "Xoá thành công";
	}
}
