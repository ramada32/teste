package com.ctbcbank.lab.backend.service.impl;

import com.ctbcbank.lab.backend.mapper.TransferMapper;
import com.ctbcbank.lab.backend.model.entity.TransferEntity;
import com.ctbcbank.lab.backend.model.repository.TransferRepository;
import com.ctbcbank.lab.backend.model.request.TransferRequest;
import com.ctbcbank.lab.backend.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

        private final TransferRepository transferRepository;


        @Override
        public Double calculateRateTransfer(LocalDateTime finalDate){

            Duration daysRateTransfer = Duration.between(LocalDateTime.now() , finalDate.toLocalDate());
            Double rate = 0.0;

            Long daysCalculate = daysRateTransfer.toDays();

            if(daysCalculate == 0){
                rate = 2.5;
            }else if(daysCalculate >= 11 && daysCalculate <= 20){
                rate = 8.2;
            }else if(daysCalculate <= 30){
                rate = 6.9;
            }else if(daysCalculate <= 40){
                rate = 4.7;
            }else if(daysCalculate <= 50){
                rate = 1.7;
            }

            return rate;
        }

    @Override
    public TransferEntity create(TransferRequest transferRequest) {
        TransferEntity entity = TransferMapper.mapEntity(transferRequest);

        return transferRepository.save(entity);
    }

    @Override
    public TransferEntity update(TransferRequest transferRequest, Integer id) {
            TransferEntity entity = findById(id);
            TransferMapper.mapUpdate(transferRequest, entity);
            transferRepository.save(entity);
        return entity;
    }

    @Override
    public List<TransferEntity> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public TransferEntity findById(Integer id) {

        return Optional.of(transferRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new RuntimeException("deu ruim"));
    }

    @Override
    public void delete(Integer id) {
        transferRepository.delete(findById(id));
    }


}
