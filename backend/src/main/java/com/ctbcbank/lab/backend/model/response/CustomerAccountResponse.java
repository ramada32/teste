package com.ctbcbank.lab.backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountResponse {

    private Integer id;
    private String name;
    private BigDecimal valueAccount;
}
