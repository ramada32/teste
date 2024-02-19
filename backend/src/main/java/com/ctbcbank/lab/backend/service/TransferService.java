package com.ctbcbank.lab.backend.service;

import com.ctbcbank.lab.backend.model.entity.TransferEntity;
import com.ctbcbank.lab.backend.model.request.TransferRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferService {

    Double calculateRateTransfer(LocalDateTime finalDate);

    TransferEntity create(TransferRequest transferRequest);

    List<TransferEntity> findAll();

    TransferEntity findById(Integer id);

}
