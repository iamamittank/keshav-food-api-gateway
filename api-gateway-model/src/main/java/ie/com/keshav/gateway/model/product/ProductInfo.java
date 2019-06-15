package ie.com.keshav.gateway.model.product;

import ie.com.keshav.gateway.model.enums.QuantityUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static ie.com.keshav.gateway.model.enums.QuantityUnit.KILOGRAM;

/**
 * Created by Amit Tank
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductInfo extends Product {

    private float quantity;

    private QuantityUnit quantityUnit = KILOGRAM;

    private int availableStock;

    private String notes;

}
