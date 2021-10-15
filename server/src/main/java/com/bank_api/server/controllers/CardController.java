package com.bank_api.server.controllers;

import com.bank_api.server.dto.BalanceResponce;
import com.bank_api.server.services.ClientCardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {
    private final ClientCardService clientCardService;
    private final ObjectMapper objectMapper;

    public CardController(ClientCardService clientCardService, ObjectMapper objectMapper) {
        this.clientCardService = clientCardService;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(value = "{cardId}/balance", method = RequestMethod.GET)
    @SneakyThrows
    public String getBalance(@PathVariable("cardId") Long cardId) {
        return objectMapper.writeValueAsString(new BalanceResponce(cardId, clientCardService.getBalance(cardId)));
    }

    @PutMapping(value = "balance", consumes = MediaType.APPLICATION_JSON_VALUE)
    @SneakyThrows
    public String topUpBalance(@RequestBody BalanceResponce balanceResponce) {
        clientCardService.topUpBalance(balanceResponce.getCardId(), balanceResponce.getSumma());
        balanceResponce.setBalance(clientCardService.getBalance(balanceResponce.getCardId()));
        return objectMapper.writeValueAsString(clientCardService.getBalance(balanceResponce.getCardId()));
    }
}
