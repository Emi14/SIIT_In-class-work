package org.siit.week8.store.product;

import org.siit.week8.store.product.exception.ProductCreationException;
import org.siit.week8.store.product.exception.ProductUpdateException;

import java.util.*;

public class ProductServiceImpl implements IProductService {

    private final Map<UUID, Product> products;

    public ProductServiceImpl() {
        this.products = new HashMap<>();
    }

    private static boolean productSatisfiesSearchCriteria(String name, Double minPrice, Double maxPrice,
                                                          Boolean isInStock, Product product) {
        if (Objects.nonNull(name) && !product.getName().toLowerCase().contains(name.toLowerCase())) {
            return false;
        }

        if (Objects.nonNull(minPrice) && Objects.nonNull(maxPrice)
                && (product.getPrice() < minPrice || product.getPrice() > maxPrice)) {
            return false;
        }

        if (Objects.nonNull(isInStock) && isInStock && product.getStock() <= 0) {
            return false;
        }
        return true;
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

    public List<Product> searchProductsByNamePriceRangeAndStock(String name,
                                                                Double minPrice, Double maxPrice, Boolean isInStock) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (productSatisfiesSearchCriteria(name, minPrice, maxPrice, isInStock, product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void setDiscount(int discountValuePercentage) {
        for (Product product : products.values()) {
            double currentPrice = product.getPrice();
            double discountValue = discountValuePercentage * currentPrice / 100;
            product.setPrice(currentPrice - discountValue);
        }

    }
}
