package org.siit.week8.store;

import org.siit.week8.store.client.Client;
import org.siit.week8.store.client.ClientServiceImpl;
import org.siit.week8.store.client.IClientService;
import org.siit.week8.store.client.exception.ClientCreationException;
import org.siit.week8.store.product.IProductService;
import org.siit.week8.store.product.Product;
import org.siit.week8.store.product.ProductServiceImpl;
import org.siit.week8.store.product.exception.ProductCreationException;

/**
 * Write a program that simulates a store having multiple products which can be bought by multiple clients.
 * - As a client I want to have an account created (username and password)
 * - As a client I want to be able to login in store by using my account credentials
 * - As a client I want to be able to change my password
 * - As a client I want to be able to place an order
 * - As a client I want to be able to see my order status
 * <p>
 * - As a store manager I want to have more products in my store
 * - As a store manager I want to see the available stock for each product
 */
public class Store {

    private static final IClientService clientService = new ClientServiceImpl();
    private static final IProductService productService = new ProductServiceImpl();

    @SuppressWarnings(value = "TryWithIdenticalCatches")
    public static void main(String[] args) {

        try {
            Client client = clientService.createAccount("gigel", "1234565", "1234565");
            System.out.println(client);
            Product product = productService.createProduct("iPad Mini 64 GB", 2450.99, 12);
            System.out.println(product);
        } catch (ClientCreationException e) {
            e.printStackTrace();
        } catch (ProductCreationException e) {
            e.printStackTrace();
        }

    }
}