package com.ctbcbank.lab.backend.model.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountRequest {

    private String name;
    private BigDecimal valueAccount;
}
