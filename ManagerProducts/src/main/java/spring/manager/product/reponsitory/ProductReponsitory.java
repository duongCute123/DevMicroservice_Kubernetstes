package spring.manager.product.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.manager.product.entity.Product;

public interface ProductReponsitory extends JpaRepository<Product, Integer> {

}
