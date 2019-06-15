package ie.com.keshav.gateway.business.service;

import ie.com.keshav.gateway.model.product.Product;
import ie.com.keshav.gateway.model.product.ProductInfo;

import java.util.List;
import java.util.Optional;

/**
 * A service interface to provide business version of the request.
 *
 * Created by Amit Tank
 */
public interface ProductService {

    /**
     * Returns {@link List} of all available {@link Product}.
     *
     * @return {@link List} of {@link Product}
     */
    List<Product> getAllProducts();

    /**
     * Retrieves a single {@link ProductInfo} for specified <i>productId</i>.
     *
     * @param productId Id of the product
     * @return {@link ProductInfo} of a productId.
     */
    Optional<ProductInfo> getProductInfo(int productId);

}
