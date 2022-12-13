package org.siit.week8.store.client;

import org.siit.week8.store.client.exception.ClientCreationException;
import org.siit.week8.store.client.exception.LoginException;
import org.siit.week8.store.client.exception.PasswordUpdateException;
import org.siit.week8.store.order.exception.OrderException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClientServiceImpl implements IClientService {

    private final Map<String, Client> clients;

    public ClientServiceImpl() {
        clients = new HashMap<>();
    }

    @Override
    public Client createAccount(String username, String password, String repeatPassword) throws ClientCreationException {
        if (Objects.nonNull(clients.get(username))) {
            throw new ClientCreationException("The username is already used. Try another one.");
        }
        if (!password.equals(repeatPassword)) {
            throw new ClientCreationException("Provided passwords do not match.");
        }
        Client client = new Client(username, password);
        clients.put(username, client);
        return client;
    }

    @Override
    public void login(String username, String password) throws LoginException {
        Client client = clients.get(username);

        if (Objects.isNull(client)) {
            throw new LoginException("User doesn't exist.");
        }

        if (!client.getPassword().equals(password)) {
            throw new LoginException("Invalid password. Try again.");
        }
        client.setClientStatus(ClientStatus.LOGGED);
    }

    @Override
    public void logout(Client client) {
        client.setClientStatus(ClientStatus.NOT_LOGGED);
    }

    @Override
    public void updatePassword(String username, String oldPassword, String newPassword, String repeatNewPassword)
            throws PasswordUpdateException {
        Client client = clients.get(username);

        if (Objects.isNull(client)) {
            throw new PasswordUpdateException("User does not exist.");
        }

        if (!client.getPassword().equals(oldPassword)) {
            throw new PasswordUpdateException("Invalid old password.");
        }

        if (!newPassword.equals(repeatNewPassword)) {
            throw new PasswordUpdateException("New password do not match.");
        }

        client.setPassword(newPassword);
    }

    @Override
    public void placeOrder(Client client) throws OrderException {
        if (client.getCurrentOrder().getCart().isEmpty()) {
            throw new OrderException("Cart is empty");
        }
        client.placeOrder();
    }
}
