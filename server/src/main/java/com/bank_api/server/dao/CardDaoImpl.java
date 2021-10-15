package com.bank_api.server.dao;

import com.bank_api.server.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Component
public class CardDaoImpl implements CardDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CardDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Card> getListOfCards(String accountNumber) {
        return jdbcTemplate.query("SELECT * FROM CARDS WHERE ACCOUNTNUMBER=?",
                new BeanPropertyRowMapper<>(Card.class), accountNumber) ;
    }

    @Override
    public Card getCard(Long id) {
        return jdbcTemplate.query("SELECT * FROM CARDS WHERE id=?",
                new BeanPropertyRowMapper<>(Card.class), id)
                .stream().findAny().orElse(null);
    }

    @Override
    public Long createCard(Card card) {
        String INSERT_MESSAGE_SQL = "INSERT INTO cards(ACCOUNTNUMBER, CARDNUMBER, BALANCE) VALUES ( ?, ?, ? )";

            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement(INSERT_MESSAGE_SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, card.getAccountNumber());
                ps.setString(2, card.getCardNumber());
                ps.setDouble(3, card.getBalance());
                return ps;
            }, keyHolder);

        return (Long) keyHolder.getKey();
    }

    @Override
    public void editCard(Long id, Card updatedCard) {
        jdbcTemplate.update("UPDATE cards SET ACCOUNTNUMBER=?, CARDNUMBER=?,BALANCE=? WHERE ID=?",
                updatedCard.getAccountNumber(), updatedCard.getCardNumber(), updatedCard.getBalance(), updatedCard.getId());
    }
}
