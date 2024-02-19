package com.ctbcbank.lab.backend.controller;

import com.ctbcbank.lab.backend.mapper.CustomerAccountMapper;
import com.ctbcbank.lab.backend.mapper.TransferMapper;
import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;
import com.ctbcbank.lab.backend.model.entity.TransferEntity;
import com.ctbcbank.lab.backend.model.request.TransferRequest;
import com.ctbcbank.lab.backend.model.response.CustomerAccountResponse;
import com.ctbcbank.lab.backend.model.response.TransferResponse;
import com.ctbcbank.lab.backend.service.CustomerAccountService;
import com.ctbcbank.lab.backend.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/transfer")
@CrossOrigin(origins = "http://localhost:4200")
public class TransferController {


    private final TransferService transferService;

    public final CustomerAccountService customerAccountService;


        @GetMapping
        public ResponseEntity<List<TransferResponse>> findAll(){

            List<TransferEntity> entities = transferService.findAll();
            return ResponseEntity.ok(TransferMapper.mapResponseList(entities));
        }

        @GetMapping(value = "/customer/{id}")
        public ResponseEntity<TransferResponse> findById(@PathVariable Integer id){

            TransferResponse response = Optional.ofNullable(transferService.findById(id))
                    .map(TransferMapper::mapResponse)
                    .orElse(null);

            return ResponseEntity.ok(response);
        }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<TransferResponse>> findTransferCustomerAccountId(@PathVariable Integer id){

        List<TransferResponse> response = Optional.ofNullable(transferService.findByCustomerAccountId(id))
                .map(TransferMapper::mapResponseList)
                .orElse(null);

        return ResponseEntity.ok(response);
    }
        @PostMapping
        public ResponseEntity<TransferResponse> save(@RequestBody TransferRequest request){

            TransferEntity entity = transferService.create(request);
            return ResponseEntity.ok(TransferMapper.mapResponse(entity));

        }

}
