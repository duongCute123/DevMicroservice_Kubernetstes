package spring.redis.reponse;

import org.springframework.data.mongodb.repository.MongoRepository;

import spring.redis.entity.Product;

public interface ProductMongoReponse extends MongoRepository<Product,Integer> {

}
