package org.siit.week8.store.client;

import org.siit.week8.store.client.exception.ClientCreationException;
import org.siit.week8.store.client.exception.LoginException;
import org.siit.week8.store.client.exception.PasswordUpdateException;
import org.siit.week8.store.order.exception.OrderException;

public interface IClientService {

    Client createAccount(String username, String password, String repeatPassword) throws ClientCreationException;

    void login(String username, String password) throws LoginException;

    void logout(Client client);

    void updatePassword(String username, String oldPassword, String newPassword, String repeatNewPassword) throws PasswordUpdateException;

    void placeOrder(Client client) throws OrderException;
}
