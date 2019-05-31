package ie.com.keshav.gateway.model.product;

import lombok.Data;

/**
 * Created by Amit Tank
 */
@Data
public class Product {

    private int productId;

    private String productName;

    private String description;

    private float price;

    private String imageUrl;

}
