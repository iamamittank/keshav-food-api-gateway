package ie.com.keshav.gateway.business.repository;

import ie.com.keshav.gateway.model.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Amit Tank
 */
@Slf4j
@Component
@Profile({"dev"})
public class ProductDataLoader {

    public ProductDataLoader(ProductRepository repository) {
        /*log.info("Data is being loaded in in-memody database.");
        ProductBuilder productBuilder = new ProductBuilder();

        Product product1 = productBuilder
                .setProductId(1)
                .setProductName("Ratlami Sev")
                .setDescription("Spice gram flour noodles")
                .setPrice(3.50f)
                .setImageUrl("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg")
                .build();

        Product product2 = productBuilder
                .setProductId(2)
                .setProductName("Chana Dal")
                .setDescription("Whole gram lentils")
                .setPrice(3f)
                .setImageUrl("https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg")
                .build();

        Product product3 = productBuilder
                .setProductId(3)
                .setProductName("Moong Dal")
                .setDescription("Whole lentils")
                .setPrice(2.80f)
                .setImageUrl("https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg")
                .build();

        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        log.info("Data load complete.");*/
    }

    class ProductBuilder {

        private int productId;

        private String productName;

        private String description;

        private float price;

        private String imageUrl;

        ProductBuilder setProductId(int productId) {
            this.productId = productId;
            return this;
        }

        ProductBuilder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        ProductBuilder setPrice(float price) {
            this.price = price;
            return this;
        }

        ProductBuilder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        Product build() {
            Product product = new Product();
            product.setProductId(this.productId);
            product.setProductName(this.productName);
            product.setDescription(this.description);
            product.setPrice(this.price);
            product.setImageUrl(this.imageUrl);
            return product;
        }
    }

}
