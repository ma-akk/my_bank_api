package com.bank_api.server.dao;

import com.bank_api.server.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDaoImpl implements ClientDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> getListOfClients() {
        return jdbcTemplate.query("SELECT * FROM clients", new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public Client getClient(String accountNumber) {
        return jdbcTemplate.query("SELECT * FROM clients WHERE ACCOUNTNUMBER=?", new BeanPropertyRowMapper<>(Client.class),
                        accountNumber).stream().findAny().orElse(null);
    }
}
