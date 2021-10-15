package com.bank_api.server.services.client;

import com.bank_api.server.dao.ClientDAO;
import com.bank_api.server.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements  ClientService{
    private final ClientDAO clientDAO;

    @Autowired
    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public List<Client> getListOfClients() {
        return clientDAO.getListOfClients();
    }

    @Override
    public Client getClient(int id) {
        return null;
    }

    @Override
    public Client getClient(String accountNumber) {
        return clientDAO.getClient(accountNumber);
    }
}
