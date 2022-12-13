package org.siit.week8.store.product;

import org.siit.week8.store.product.exception.ProductCreationException;
import org.siit.week8.store.product.exception.ProductUpdateException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductServiceImpl implements IProductService {

    private final Map<UUID, Product> products;

    public ProductServiceImpl() {
        this.products = new HashMap<>();
    }

    @Override
    public Product createProduct(String name, double price, int stock) throws ProductCreationException {
        if (price <= 0) {
            throw new ProductCreationException("The price must be positive.");
        }

        if (stock < 0) {
            throw new ProductCreationException("The stock must be positive.");
        }

        Product product = new Product(UUID.randomUUID(), name, price, stock);
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public void updateProductStock(Product product, int newStock) throws ProductUpdateException {
        if (newStock < 0) {
            throw new ProductUpdateException("The stock must be positive.");
        }
        product.setStock(newStock);
    }

    @Override
    public void updateProductPrice(Product product, int newPrice) throws ProductUpdateException {
        if (newPrice <= 0) {
            throw new ProductUpdateException("The price must be positive.");
        }
        product.setPrice(newPrice);
    }
}
