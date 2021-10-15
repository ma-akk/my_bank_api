package com.bank_api.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Card {
    @JsonProperty
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String accountNumber;

    @JsonProperty
    private String cardNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private double balance;

}
