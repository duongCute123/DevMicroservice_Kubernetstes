package spring.manager.product.controller;

import java.net.ConnectException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import spring.manager.product.ManagerProductsApplication;
import spring.manager.product.entity.Product;
import spring.manager.product.entity.User;
import spring.manager.product.reponsitory.OrderReponsitory;
import spring.manager.product.reponsitory.ProductRedisReponse;
import spring.manager.product.reponsitory.ProductReponsitory;
import spring.manager.product.service.ProductService;

@RestController
@RequestMapping("/api/v1")
@EnableRetry
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ProductReponsitory productReponsitory;
	@Autowired
	ProductRedisReponse productRedisReponse;
	Logger logger = LoggerFactory.getLogger(ManagerProductsApplication.class);

	// Lay danh sach san pham
	@GetMapping("/product")
	public List<Product> findAllProduct() {
		List<Product> listProducts = new ArrayList<>();
		if (productRedisReponse.findAll() == null) {
			listProducts = productService.findAllProducts();
		} else {
			listProducts = productRedisReponse.findAll();
		}
		return listProducts;

	}

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		productService.addProducts(product);
		productRedisReponse.saveProduct(product);
		return product;
	}

	// Lấy thong tin người dùng và product
	// Lấy và lưu đơn hàng vào trong redis
	@GetMapping("/orderproduct/{id}/{productId}")
	@Retryable(retryFor = { ConnectException.class, ArithmeticException.class,
			ResourceAccessException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public ResponseEntity<OrderReponsitory> orderProductByUser(@PathVariable Integer id,
			@PathVariable Integer productId) throws URISyntaxException, ConnectException {
		System.out.println("Đang call api nhe!!");
		OrderReponsitory orderReponsitory = new OrderReponsitory();

		try {
			String url = "http://localhost:8801/api/v2/user/" + id;
			ResponseEntity<User> reponse = restTemplate.getForEntity(url, User.class);
			Optional<Product> optional = productReponsitory.findById(productId);
			Product product = null;
			if (optional.isPresent()) {
				product = optional.get();
			} else {
				new RuntimeException("Khong co user theo id này");
			}
			User user = reponse.getBody();
			orderReponsitory.setUser(user);
			orderReponsitory.setProduct(product);
			productRedisReponse.saveOrder(orderReponsitory);
			return new ResponseEntity<OrderReponsitory>(orderReponsitory, HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("other exception occurred. " + ex.getMessage());
			if (ex instanceof ConnectException) {
				logger.info("throwing");
				throw new ConnectException(ex.getMessage());
			}
			if (ex instanceof ResourceAccessException) {
				logger.info("throwing resourceAccessException");
				throw new ResourceAccessException(ex.getMessage());
			}
		}
		return null;
	}

	@Recover
	public String recover(ConnectException e) throws URISyntaxException {
		logger.info("Lỗi kết nối với server:" + LocalDateTime.now());
		return e.getMessage();
	}

	@Recover
	public String recover(ArithmeticException ex) {
		logger.info("Lỗi gọi api:" + LocalDateTime.now());
		return "Không thể gọi api";
	}

	@Recover
	public String recover(ResourceAccessException ex) {
		logger.info("ResourceAccessException recovered at:" + LocalDateTime.now());
		return "Không thể gọi api";
	}
}
