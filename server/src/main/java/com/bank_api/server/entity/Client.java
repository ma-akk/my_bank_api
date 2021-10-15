package com.bank_api.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private int id;

    private String name;

    private String accountNumber;

    @Override
    public String toString() {
        return  "Client{name:" + name + "}";
    }
}
