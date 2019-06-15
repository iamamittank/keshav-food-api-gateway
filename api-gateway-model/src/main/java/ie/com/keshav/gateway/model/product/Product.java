package ie.com.keshav.gateway.model.product;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by Amit Tank
 */
@Data
public class Product {

    @Id
    private int productId;

    private String productName;

    private String description;

    private float price;

    private String imageUrl;

}
