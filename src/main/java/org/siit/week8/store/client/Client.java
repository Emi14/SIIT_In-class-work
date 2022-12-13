package org.siit.week8.store.client;

import org.siit.week8.store.order.Order;
import org.siit.week8.store.order.OrderStatus;

import java.util.List;

public class Client {

    private String userName;
    private String password; //todo look into creating a new class for password to add validation
    private ClientStatus clientStatus = ClientStatus.NOT_LOGGED;
    private Order currentOrder;
    private List<Order> orderHistory;

    public Client(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void placeOrder() {
        currentOrder.updateOrderStatus(OrderStatus.DELIVERED);
        this.getOrderHistory().add(currentOrder);
        this.currentOrder = new Order();
    }

    // Todo replace getters/setters with Lombok

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    @Override
    public String toString() {
        return "Client{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", clientStatus=" + clientStatus +
                ", currentOrder=" + currentOrder +
                ", orderHistory=" + orderHistory +
                '}';
    }
}
