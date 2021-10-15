package com.bank_api.server;

import com.bank_api.server.controllers.ClientCardsController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = {"/data-test.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ServerApplicationTests  {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ClientCardsController controller;

	@Test
	public void contextLoadsListOfCards() throws Exception {
		this.mockMvc.perform(get("/client/00000000/cards"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("[{\"id\":4,\"cardNumber\":\"3131\"},{\"id\":5,\"cardNumber\":\"3232\"}]")));
	}

	@Test
	public void createCardTest() throws Exception {
		String accountJson = "{\"accountNumber\":\"00000000\"}";
		this.mockMvc.perform(post("/client/newcard")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(accountJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("\"id\"")))
				.andExpect(content().string(containsString("\"cardNumber\"")));
	}

}
