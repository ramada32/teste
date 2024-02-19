package com.ctbcbank.lab.backend.service.impl;

import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;
import com.ctbcbank.lab.backend.model.repository.CustomerAccountRepository;
import com.ctbcbank.lab.backend.service.CustomerAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerAccountServiceImpl implements CustomerAccountService {


    private final CustomerAccountRepository customerAccountRepository;

    @Override
    public List<CustomerAccountEntity> findAll() {
        return customerAccountRepository.findAll();
    }

    @Override
    public CustomerAccountEntity findById(Integer id) {

        return Optional.of(customerAccountRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new RuntimeException("deu ruim"));
    }

    @Override
    public CustomerAccountEntity update(BigDecimal value, Integer id) {
        CustomerAccountEntity entity = findById(id);

        entity.setValueAccount(value);
        customerAccountRepository.save(entity);
        return entity;
    }
}
