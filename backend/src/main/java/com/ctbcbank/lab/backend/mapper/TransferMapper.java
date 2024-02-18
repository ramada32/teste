package com.ctbcbank.lab.backend.mapper;

import com.ctbcbank.lab.backend.model.entity.TransferEntity;
import com.ctbcbank.lab.backend.model.request.TransferRequest;
import com.ctbcbank.lab.backend.model.response.TransferResponse;

import java.util.List;
import java.util.stream.Collectors;

public class TransferMapper {


    public static void mapUpdate(TransferRequest request, TransferEntity entity){

        entity.setValueTransfer(request.getValueTransfer());
        entity.setRateTransfer(request.getRateTransfer());
        entity.setValueTransfer(request.getValueTransfer());
        entity.setDateFinal(request.getDateFinal());
        entity.setNumberAccount(request.getNumberAccount());
        entity.setDateInitial(request.getDateInitial());
        entity.setFreeValue(request.getFreeValue());
    }
    public static TransferEntity mapEntity(TransferRequest request){

        return TransferEntity.builder()
                .numberAccount(request.getNumberAccount())
                .dateInitial(request.getDateInitial())
                .dateFinal(request.getDateFinal())
                .rateTransfer(request.getRateTransfer())
                .valueTransfer(request.getValueTransfer())
                .freeValue(request.getFreeValue())
                .build();

    }


    public static TransferResponse mapResponse(TransferEntity entity){

        return TransferResponse.builder()
                .id(entity.getId())
                .numberAccount(entity.getNumberAccount())
                .dateInitial(entity.getDateInitial())
                .dateFinal(entity.getDateFinal())
                .rateTransfer(entity.getRateTransfer())
                .valueTransfer(entity.getValueTransfer())
                .freeValue(entity.getFreeValue())
                .build();
    }

    public static List<TransferResponse> mapResponseList(List<TransferEntity> entities){
        return entities.stream()
                .map(TransferMapper::mapResponse)
                .collect(Collectors.toList());
    }
}
