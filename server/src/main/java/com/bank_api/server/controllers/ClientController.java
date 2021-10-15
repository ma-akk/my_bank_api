package com.bank_api.server.controllers;

import com.bank_api.server.services.client.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients", produces = "application/json")
public class ClientController {
    private final ObjectMapper objectMapper;
    private final ClientService clientService;

    @Autowired
    public ClientController(ObjectMapper objectMapper, ClientService clientService) {
        this.objectMapper = objectMapper;
        this.clientService = clientService;
    }

    @GetMapping
    @SneakyThrows
    public String getListOfClients() {
        return objectMapper.writeValueAsString(clientService.getListOfClients());
    }

    @GetMapping("{accountNumber}")
    @SneakyThrows
    public String getClient(@PathVariable ("accountNumber") String accountNumber) {
        return objectMapper.writeValueAsString(clientService.getClient(accountNumber));
    }
}
