package ie.com.keshav.gateway.web.controller;

import ie.com.keshav.gateway.business.service.ProductService;
import ie.com.keshav.gateway.model.product.Product;
import ie.com.keshav.gateway.model.product.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Amit Tank
 */
@Slf4j
@RestController
public class ProductController {

    private static final String ENTRY_LOG = "Entered [%s] service";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        log.info(String.format(ENTRY_LOG, "Get All Products"));
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<ProductInfo> getProductById(
            @PathVariable int productId
    ) {
        log.info(String.format(ENTRY_LOG, "Get Product By Id"));
        Optional<ProductInfo> productInfoOptional = productService.getProductInfo(productId);
        if(productInfoOptional.isPresent()) {
            return ResponseEntity.ok(productInfoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
