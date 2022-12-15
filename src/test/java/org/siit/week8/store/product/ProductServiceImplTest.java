package org.siit.week8.store.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.week8.store.product.exception.ProductCreationException;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl();
    }

    @Test
    void testCreateProduct_whenInvalidParameters_thenExceptionIsThrown() {
        assertThrows(ProductCreationException.class,
                () -> productService.createProduct("TV LG", -1, 12));
    }

    @Test
    void testCreateProduct_whenValidParameters_thenExceptionIsThrown() throws ProductCreationException {
        int numberOfProductsBeforeCreation = productService.getAllProducts().size();
        Product product = productService.createProduct("TV LG", 1299, 214);
        int numberOfProductsAfterCreation = productService.getAllProducts().size();
        assertNotNull(product);
        assertEquals(numberOfProductsAfterCreation, numberOfProductsBeforeCreation + 1);
    }

}