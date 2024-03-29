package com.ctbcbank.lab.backend.mapper;

import com.ctbcbank.lab.backend.model.entity.CustomerAccountEntity;
import com.ctbcbank.lab.backend.model.response.CustomerAccountResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerAccountMapper {

    public static CustomerAccountResponse mapResponse(CustomerAccountEntity entity){

        return CustomerAccountResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .valueAccount(entity.getValueAccount())
                .build();
    }

    public static List<CustomerAccountResponse> mapResponseList(List<CustomerAccountEntity> entities){
        return entities.stream()
                .map(CustomerAccountMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
