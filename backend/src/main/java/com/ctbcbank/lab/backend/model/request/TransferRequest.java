package com.ctbcbank.lab.backend.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {

    private Integer numberAccount;
    private Integer numberAccountDestiny;
    private LocalDateTime dateFinal;
    private BigDecimal valueTransfer;
}
