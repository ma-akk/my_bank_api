package com.bank_api.server.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BalanceResponce {
    @JsonProperty
    private Long cardId;
    @JsonProperty
    private double balance;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double summa;

    public BalanceResponce(Long cardId, double balance) {
        this.cardId = cardId;
        this.balance = balance;
    }
}
