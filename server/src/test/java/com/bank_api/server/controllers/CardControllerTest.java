package com.bank_api.server.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = {"/data-test.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientCardsController controller;

    @Test
    void getBalance() throws Exception {
        this.mockMvc.perform(get("/cards/2/balance"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("500")));
    }

//     @Test
//     void topUpBalance() throws Exception{
//         String accountJson = "{\"cardId\":\"1\", \"summa\":10000}";
//         this.mockMvc.perform(put("/cards/balance")
//                         .contentType(MediaType.APPLICATION_JSON_VALUE)
//                         .content(accountJson))
//                 .andDo(print())
//                 .andExpect(status().isOk())
//                 .andExpect(content().string(containsString("\"balance\"")))
//                 .andExpect(content().string(containsString("10100")));
//     }
}
