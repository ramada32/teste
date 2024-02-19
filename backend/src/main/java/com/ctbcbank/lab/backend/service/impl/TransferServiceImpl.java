package com.ctbcbank.lab.backend.service.impl;

import com.ctbcbank.lab.backend.mapper.TransferMapper;
import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;
import com.ctbcbank.lab.backend.model.entity.TransferEntity;
import com.ctbcbank.lab.backend.model.repository.TransferRepository;
import com.ctbcbank.lab.backend.model.request.TransferRequest;
import com.ctbcbank.lab.backend.service.CustomerAccountService;
import com.ctbcbank.lab.backend.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

        private final TransferRepository transferRepository;

        private final CustomerAccountService customerAccountService;

        @Override
        public Double calculateRateTransfer(LocalDateTime finalDate){

            double rate = 0.0;

            long daysCalculate = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.from(finalDate));

            if(daysCalculate == 0){
                rate = 2.5;
            }else if(daysCalculate >= 11 && daysCalculate <= 20){
                rate = 8.2;
            }else if(daysCalculate >= 21 && daysCalculate <= 30){
                rate = 6.9;
            }else if(daysCalculate >= 31 && daysCalculate <= 40){
                rate = 4.7;
            }else if(daysCalculate >= 41 && daysCalculate <= 50){
                rate = 1.7;
            }

            return rate;
        }

    @Override
    public TransferEntity create(TransferRequest transferRequest) {

        CustomerAccountEntity customerAccount = Optional.ofNullable(
                customerAccountService.findById(transferRequest.getNumberAccount())).orElse(null);

        CustomerAccountEntity customerAccountDestiny = Optional.ofNullable(
                customerAccountService.findById(transferRequest.getNumberAccountDestiny())).orElse(null);

        TransferEntity entity = TransferMapper.mapEntity(transferRequest);
        entity.setRateTransfer(calculateRateTransfer(LocalDateTime.from(transferRequest.getDateFinal())));
        entity.setFreeValue(new BigDecimal(transferRequest.getValueTransfer().doubleValue() * (entity.getRateTransfer()/100)));
        entity.setCustomerAccount(customerAccount);
        entity.setCustomerAccountDestiny(customerAccountDestiny);
        if(entity.getRateTransfer() == 0.0
                || entity.getValueTransfer().doubleValue() > customerAccount.getValueAccount().doubleValue()
                || entity.getCustomerAccount() == entity.getCustomerAccountDestiny()){
            throw new RuntimeException("Não pode ser feito transferencia");
        }else{
            if(entity.getRateTransfer() == 2.5){
                customerAccountService.update(
                        customerAccountDestiny.getValueAccount().add(entity.getValueTransfer()), transferRequest.getNumberAccountDestiny());

                BigDecimal result = new BigDecimal(String.valueOf(customerAccount.getValueAccount().subtract(entity.getFreeValue()).subtract(transferRequest.getValueTransfer())));
                customerAccount.setValueAccount(result);

                customerAccountService.update(customerAccount.getValueAccount(), transferRequest.getNumberAccount());

            }

            return transferRepository.save(entity);
        }
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
                .orElseThrow(() -> new RuntimeException("Erro nenhum dado com o id informado"));
    }

    @Override
    public List<TransferEntity> findByCustomerAccountId(Integer id){

       return  Optional.of(transferRepository.findByCustomerAccountId(id))
                .orElseThrow(() -> new RuntimeException("Erro nenhum dado com o id informado"));
    }
}
