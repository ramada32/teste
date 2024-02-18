package com.ctbcbank.lab.backend.controller;

import com.ctbcbank.lab.backend.mapper.CustomerAccountMapper;
import com.ctbcbank.lab.backend.mapper.TransferMapper;
import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;
import com.ctbcbank.lab.backend.model.entity.TransferEntity;
import com.ctbcbank.lab.backend.model.response.CustomerAccountResponse;
import com.ctbcbank.lab.backend.model.response.TransferResponse;
import com.ctbcbank.lab.backend.service.CustomerAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerAccountController {


    private final CustomerAccountService customerAccountService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerAccountResponse> findById(@PathVariable Integer id){

        CustomerAccountResponse response = Optional.ofNullable(customerAccountService.findById(id))
                .map(CustomerAccountMapper::mapResponse)
                .orElse(null);

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<CustomerAccountResponse>> findAllCustomer(){

        List<CustomerAccountEntity> entities = customerAccountService.findAll();
        return ResponseEntity.ok(CustomerAccountMapper.mapResponseList(entities));
    }


}
