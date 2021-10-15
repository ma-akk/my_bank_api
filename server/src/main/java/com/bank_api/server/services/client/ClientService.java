package com.bank_api.server.services.client;

import com.bank_api.server.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getListOfClients();
    Client getClient(int id);
    Client getClient(String accountNumber);
}
