package org.siit.week8.store.client;

import lombok.Data;
import lombok.NonNull;
import org.siit.week8.store.order.Order;
import org.siit.week8.store.order.OrderStatus;
import org.siit.week8.store.order.exception.OrderException;

import java.util.ArrayList;
import java.util.List;

@Data
public class Client {

    @NonNull
    private String userName;
    @NonNull
    private String password; //todo look into creating a new class for password to add validation
    private ClientStatus clientStatus = ClientStatus.NOT_LOGGED;
    private Order currentOrder = new Order();
    private List<Order> orderHistory = new ArrayList<>();

    public void placeOrder() throws OrderException {
        currentOrder.validateStock();
        currentOrder.updateOrderStatus(OrderStatus.DELIVERED);
        currentOrder.updateStockAfterOrderIsCompleted();
        this.getOrderHistory().add(currentOrder);
        this.currentOrder = new Order();
    }
}


