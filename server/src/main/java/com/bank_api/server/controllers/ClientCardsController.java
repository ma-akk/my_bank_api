package com.bank_api.server.controllers;

import com.bank_api.server.dto.AccountResponce;
import com.bank_api.server.services.ClientCardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value= "/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientCardsController {

    private final ClientCardService clientCardService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ClientCardsController(ClientCardService clientCardService, ObjectMapper objectMapper) {
        this.clientCardService = clientCardService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("{accountNumber}/cards")
    @SneakyThrows
    public String getListOfCard(@PathVariable("accountNumber") String accountNumber) {
        return objectMapper.writeValueAsString(clientCardService.getListOfCards(accountNumber));
    }

    @PostMapping(value = "newcard", consumes = MediaType.APPLICATION_JSON_VALUE)
    @SneakyThrows
    public String createCard(@RequestBody AccountResponce accountResponce) {
        return objectMapper.writeValueAsString(clientCardService.createCard(accountResponce.getAccountNumber()));
    }

}
