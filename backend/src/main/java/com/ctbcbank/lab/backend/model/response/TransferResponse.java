package com.ctbcbank.lab.backend.model.response;

import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponse {

    private Integer id;
    private Integer numberAccount;
    private Integer numberAccountDestiny;
    private LocalDateTime dateInitial;
    private LocalDateTime dateFinal;
    private Double rateTransfer;
    private BigDecimal valueTransfer;
    private BigDecimal freeValue;
}
