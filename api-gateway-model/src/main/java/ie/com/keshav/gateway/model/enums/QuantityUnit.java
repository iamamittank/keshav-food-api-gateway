package ie.com.keshav.gateway.model.enums;

/**
 * Created by Amit Tank
 */
public enum QuantityUnit {

    KILOGRAM("Kg"),

    GRAM("Grams");

    final String alias;

    QuantityUnit(String alias) {
        this.alias = alias;
    }

}
