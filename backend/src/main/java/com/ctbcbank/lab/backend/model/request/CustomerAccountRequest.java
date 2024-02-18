package com.ctbcbank.lab.backend.model.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountRequest {

    private String name;
    private Double valueAccount;
}
