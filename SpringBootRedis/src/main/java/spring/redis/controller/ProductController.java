package spring.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.redis.entity.Product;
import spring.redis.reponse.RedisReponse;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	RedisReponse redisReponse;

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		redisReponse.saveProduct(product);
		return product;
	}

	@GetMapping("/product/{id}")
	public Product findByID(@PathVariable int id) {
		return redisReponse.getById(id);
	}

	@GetMapping("/product")
	public List<Product> getList() {
		return redisReponse.findAll();
	}

	@PutMapping("/product")
	public String updateProduct(@RequestBody Product product) {
		redisReponse.updateProduct(product);
		return "Cập nhật thành công";
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		redisReponse.deleteProduct(id);
		return "Xoá thành công";
	}
}
