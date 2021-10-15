package com.bank_api.server.services;

import com.bank_api.server.entity.Card;

import java.util.List;

public interface ClientCardService {
    Card createCard(String accountNumber) ;

    List<Card> getListOfCards(String accountNumber) ;

    void topUpBalance(Long cardId, double sum);

    double getBalance(Long cardId);
}
