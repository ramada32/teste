package com.ctbcbank.lab.backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "Transfer")
@NoArgsConstructor
@AllArgsConstructor
public class TransferEntity {

    @Id
    @Column(name = "ID_TRANSFER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "NUMBER_ACCOUNT")
    private CustomerAccountEntity customerAccount;

    @ManyToOne
    @JoinColumn(name = "NUMBER_ACCOUNT_DESTINY")
    private CustomerAccountEntity customerAccountDestiny;

    @Column(name = "DATE_INITIAL")
    private LocalDateTime dateInitial;

    @Column(name = "DATE_FINAL")
    private LocalDateTime dateFinal;

    @Column(name = "RATE_TRANSFER")
    private Double rateTransfer;

    @Column(name = "FREE_VALUE_TRANSFER")
    private BigDecimal freeValue;

    @Column(name = "VALUE_TRANSFER")
    private BigDecimal valueTransfer;
}
