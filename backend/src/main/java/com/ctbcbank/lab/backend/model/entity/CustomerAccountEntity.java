package com.ctbcbank.lab.backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="NUMBER_ACCOUNT")
    private Integer id;

    @Column(name = "NAME_CLIENT")
    private String name;

    @Column(name = "VALUE_ACCOUNT")
    private Double valueAccount;

}
