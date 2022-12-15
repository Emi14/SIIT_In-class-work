package org.siit.week8.store.product;

import org.siit.week8.store.product.exception.ProductCreationException;
import org.siit.week8.store.product.exception.ProductUpdateException;

import java.util.Collections;
import java.util.List;

public interface IProductService {
    Product createProduct(String name, double price, int stock) throws ProductCreationException;

    void updateProductStock(Product product, int newStock) throws ProductUpdateException;

    void updateProductPrice(Product product, int newPrice) throws ProductUpdateException;

    List<Product> searchProductsByNamePriceRangeAndStock(String name,
                                                         Double minPrice, Double maxPrice, Boolean isInStock);

    default List<Product> getAllProducts() {
        return Collections.emptyList();
    }

    @Deprecated
    void setDiscount(int discountValuePercentage);

}
