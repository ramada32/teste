package com.ctbcbank.lab.backend.service;

import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;

import java.util.List;

public interface CustomerAccountService {

    List<CustomerAccountEntity> findAll();

    CustomerAccountEntity findById(Integer id);
}
