package com.bank_api.server.services;

import com.bank_api.server.dao.CardDaoImpl;
import com.bank_api.server.dao.ClientDaoImpl;
import com.bank_api.server.entity.Card;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardServiceImpl implements ClientCardService {

    private final CardDaoImpl cardDao;
    private final ClientDaoImpl clientDao;

    @Autowired
    public ClientCardServiceImpl(CardDaoImpl cardDao, ClientDaoImpl clientDao) {
        this.cardDao = cardDao;
        this.clientDao = clientDao;
    }

    @Override
    @SneakyThrows
    public Card createCard(String accountNumber) {
        if (clientDao.getClient(accountNumber) == null)
            throw new IllegalArgumentException("Account doesn't exist");
        Card newCard = new Card(0L, accountNumber, "00000000", 0.0);
        return cardDao.getCard(cardDao.createCard(newCard));
    }

    @Override
    public List<Card> getListOfCards(String accountNumber) {
        return cardDao.getListOfCards(accountNumber);
    }

    @Override
    public void topUpBalance(Long cardId, double sum) {
        Card updatedCard = cardDao.getCard(cardId);
        double newBalance = updatedCard.getBalance() + sum;
        updatedCard.setBalance(newBalance);
        cardDao.editCard(cardId, updatedCard);
    }

    @Override
    public double getBalance(Long cardId) {
        return cardDao.getCard(cardId).getBalance();
    }
}
