package org.siit.week8.store.order;

import org.siit.week8.store.order.exception.OrderException;
import org.siit.week8.store.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private final UUID id;
    private final Map<Product, Integer> cart;
    private OrderStatus orderStatus;
    private double totalPrice;

    public Order() {
        this.id = UUID.randomUUID();
        this.orderStatus = OrderStatus.OPEN;
        this.totalPrice = 0;
        this.cart = new HashMap<>();
    }

    public void updateCart(Product product, Integer quantity) throws OrderException {
        if (product.getStock() < quantity) {
            throw new OrderException(String.format("Insufficient stock for product: %s. " +
                    "The required quantity was %s, while the stock is %s.", product, quantity, product.getStock()));
        }
        Integer cartQuantity = cart.get(product);
        if (Objects.nonNull(cartQuantity)) {
            totalPrice -= product.getPrice() * cartQuantity;
        }
        cart.put(product, quantity); //todo revisit this logic
        totalPrice += product.getPrice() * quantity;
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

    public void validateStock() throws OrderException {
        for (Map.Entry<Product, Integer> productEntry : cart.entrySet()) {
            Product product = productEntry.getKey();
            Integer quantity = productEntry.getValue();
            if (product.getStock() < quantity) {
                throw new OrderException(String.format("Insufficient stock for product: %s. " +
                        "The required quantity was %s, while the stock is %s.", product, quantity, product.getStock()));
            }
        }
    }

    public void updateStockAfterOrderIsCompleted() {
        for (Map.Entry<Product, Integer> productEntry : cart.entrySet()) {
            Product product = productEntry.getKey();
            int existingStock = product.getStock();
            Integer soldQuantity = productEntry.getValue();
            product.setStock(existingStock - soldQuantity);
        }
    }

}
