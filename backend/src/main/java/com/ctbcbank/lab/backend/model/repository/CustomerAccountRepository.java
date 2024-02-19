package com.ctbcbank.lab.backend.model.repository;

import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository  extends JpaRepository<CustomerAccountEntity, Integer> {
}
