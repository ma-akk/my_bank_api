package com.bank_api.server.dao;

import com.bank_api.server.entity.Card;

import java.util.List;

public interface CardDAO {
    List<Card> getListOfCards(String accountNumber) ;
    Card getCard(Long id) ;
    Long createCard(Card card) ;
    void editCard(Long id, Card updatedCard) ;
}
