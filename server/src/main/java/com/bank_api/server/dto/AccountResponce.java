package com.bank_api.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountResponce {
    @JsonProperty
    private String accountNumber;
}
