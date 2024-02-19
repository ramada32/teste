package com.ctbcbank.lab.backend.model.request;

import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
