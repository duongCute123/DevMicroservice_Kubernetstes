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
import spring.redis.service.ProductService;

@RestController
@RequestMapping("/api/v2")
public class ProductsController {
	@Autowired
	ProductService productService;

	@GetMapping("/product")
	public List<Product> findAllProduct() {
		List<Product> list = productService.findAll();
		return list;
	}

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return product;
	}

	@GetMapping("/product/{id}")
	public Product findByID(@PathVariable int id) {
		return productService.findByID(id);
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return "Xoá thành công";
	}

	@PutMapping("/product/{id}")
	public String updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return "Cập nhật thành công";
	}

}
