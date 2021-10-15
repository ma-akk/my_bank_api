package com.bank_api.server.dao;

import com.bank_api.server.entity.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> getListOfClients();
    Client getClient(String accountNumber);
}
