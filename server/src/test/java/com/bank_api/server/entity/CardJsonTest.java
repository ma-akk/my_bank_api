package com.bank_api.server.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CardJsonTest {
    @SneakyThrows
    @Test
    public void deserializationSuccessable() {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = "{\n  \"id\":\"1\",\n  \"cardNumber\":\"0000\"\n}";
        Card card = objectMapper.readValue(s, Card.class);
        Card etalon = Card.builder()
                .id(1L)
                .cardNumber("0000")
                .build();
        Assertions.assertEquals(etalon, card);
    }

    @SneakyThrows
    @Test
    public void deserializationWithIgnoreFields() {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = "{\n  \"id\":\"1\",\n  \"cardNumber\":\"0000\", \"accountNumber\":\"defaultAccountNumber\",\n  \"balance\":0\n}";
        Card card = objectMapper.readValue(s, Card.class);
        Card etalon = Card.builder()
                .id(1L)
                .cardNumber("0000")
                .build();
        Assertions.assertNotEquals(etalon, card);
        Assertions.assertNotNull(card.getAccountNumber());
        assertEquals(0, card.getBalance());

    }

    @SneakyThrows
    @Test
    public void serializationSuccessable() {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = "{\n  \"id\":1,\n  \"cardNumber\":\"0000\"}";
        Card etalon = Card.builder()
                .id(1L)
                .cardNumber("0000")
                .accountNumber("111222")
                .balance(1000)
                .build();
        JsonNode result = objectMapper.valueToTree(etalon);
        JsonNode expected = objectMapper.readTree(s);
        Assertions.assertEquals(expected, result);
    }



}