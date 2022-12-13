package org.siit.week8.store.order;

import org.siit.week8.store.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Order {

    private final UUID id;
    private OrderStatus orderStatus;
    private final Map<Product, Integer> cart;
    private final double totalPrice;

    public Order() {
        this.id = UUID.randomUUID();
        this.orderStatus = OrderStatus.OPEN;
        this.totalPrice = 0;
        this.cart = new HashMap<>();
    }

    public void updateCart(Product product, Integer quantity) {
        cart.put(product, quantity); //todo revisit this logic
    }

    public void updateOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UUID getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
