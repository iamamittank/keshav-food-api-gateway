package ie.com.keshav.gateway.business.repository;

import ie.com.keshav.gateway.model.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Amit Tank
 */
public interface ProductRepository extends MongoRepository<Product, Integer> { }
