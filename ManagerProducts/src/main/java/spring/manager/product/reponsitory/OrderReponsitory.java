package spring.manager.product.reponsitory;

import java.io.Serializable;

import spring.manager.product.entity.Product;
import spring.manager.product.entity.User;

public class OrderReponsitory implements Serializable {
	private Product product;
	private User user;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
