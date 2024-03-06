package spring.manager.product.entity;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String productName;
	float gia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public Product(int id, String productName, float gia) {
		super();
		this.id = id;
		this.productName = productName;
		this.gia = gia;
	}

	public Product() {
		super();
	}

}
