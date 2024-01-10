package spring.manager.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import spring.manager.product.entity.Product;
import spring.manager.product.reponsitory.ProductReponsitory;
import spring.manager.product.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ProductReponsitory productReponsitory;

	// Lay danh sach san pham
	@GetMapping("/product")
	public List<Product> findAllProduct() {
		List<Product> listProducts = new ArrayList<>();
		listProducts = productService.findAllProducts();
		return listProducts;
	}

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		productService.addProducts(product);
		return product;
	}

	// Lấy thong tin người dùng và product
	@PostMapping("/orderproduct/{id}/{productId}")
	public List<Product> orderProductByUser(@PathVariable Integer id, @PathVariable Integer productId) {
		String url ="http://localhost:8801/api/v1/user/" + id;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		Optional<Product> optional = productReponsitory.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			new RuntimeException("Khong co user theo id này");
		}
		
		List<Product> list=new ArrayList<>();
		list.addAll(response.getBody());
		list.add(product);
		return null;
	}
}
