package ie.com.keshav.gateway.business.service.impl;

import ie.com.keshav.gateway.business.repository.ProductRepository;
import ie.com.keshav.gateway.business.service.ProductService;
import ie.com.keshav.gateway.model.product.Product;
import ie.com.keshav.gateway.model.product.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ie.com.keshav.gateway.model.enums.QuantityUnit.GRAM;

/**
 * {@inheritDoc}
 *
 * Created by Amit Tank
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<ProductInfo> getProductInfo(int productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isPresent()) {
            Product product = productOptional.get();

            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductId(product.getProductId());
            productInfo.setProductName(product.getProductName());
            productInfo.setDescription(product.getDescription());
            productInfo.setPrice(product.getPrice());
            productInfo.setImageUrl(product.getImageUrl());
            productInfo.setQuantity(500);
            productInfo.setQuantityUnit(GRAM);
            productInfo.setAvailableStock(5000);

            return Optional.of(productInfo);
        } else {
            return Optional.empty();
        }
    }
}
