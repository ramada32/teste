package com.ctbcbank.lab.backend.model.repository;


import com.ctbcbank.lab.backend.model.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Integer> {

    List<TransferEntity> findByCustomerAccountId(Integer customerId);
}
