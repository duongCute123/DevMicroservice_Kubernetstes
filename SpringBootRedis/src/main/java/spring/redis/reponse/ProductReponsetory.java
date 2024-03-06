package spring.redis.reponse;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.redis.entity.Product;

public interface ProductReponsetory extends JpaRepository<Product, Integer> {

}
