package ie.com.keshav.gateway.web.controller;

import ie.com.keshav.gateway.model.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amit Tank
 */
@Slf4j
@RestController("/products")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("Ratlami Sev");
        product1.setDescription("Spice gram flour noodles");
        product1.setPrice(3.50f);
        product1.setImageUrl("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");
        productList.add(product1);

        Product product2 = new Product();
        product2.setProductId(2);
        product2.setProductName("Chana Dal");
        product2.setDescription("Whole gram lentils");
        product2.setPrice(3f);
        product2.setImageUrl("https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");
        productList.add(product2);

        Product product3 = new Product();
        product3.setProductId(3);
        product3.setProductName("Moong Dal");
        product3.setDescription("Whole lentils");
        product3.setPrice(2.80f);
        product3.setImageUrl("https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg");
        productList.add(product3);

        return productList;
    }


}
