package org.siit.week8.store.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.week8.store.order.Order;
import org.siit.week8.store.order.OrderStatus;
import org.siit.week8.store.order.exception.OrderException;
import org.siit.week8.store.product.Product;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client("Gigel", "parola");
    }

    @Test
    void testPlaceOrder_whenOrderIsOk_thenSuccess() throws OrderException {
        client.getCurrentOrder().updateCart(new Product(UUID.randomUUID(), "TV", 1242, 21), 19);
        client.getCurrentOrder().updateCart(new Product(UUID.randomUUID(), "TV 2", 1042, 2), 1);

        Order orderToBePlaced = client.getCurrentOrder();
        client.placeOrder();

        assertEquals(OrderStatus.DELIVERED, orderToBePlaced.getOrderStatus());
        assertNotEquals(client.getCurrentOrder().getId(), orderToBePlaced.getId());
        assertFalse(client.getOrderHistory().isEmpty());
        assertEquals(orderToBePlaced, client.getOrderHistory().get(0));
    }
}