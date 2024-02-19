package com.ctbcbank.lab.backend.mapper;

import com.ctbcbank.lab.backend.model.entity.TransferEntity;
import com.ctbcbank.lab.backend.model.request.TransferRequest;
import com.ctbcbank.lab.backend.model.response.TransferResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransferMapper {

    public static TransferEntity mapEntity(TransferRequest request){

        return TransferEntity.builder()
                .dateInitial(LocalDateTime.now())
                .dateFinal(LocalDateTime.from(request.getDateFinal()))
                .valueTransfer(request.getValueTransfer())
                .build();

    }

    public static TransferResponse mapResponse(TransferEntity entity){

        return TransferResponse.builder()
                .id(entity.getId())
                .numberAccount(entity.getCustomerAccount().getId())
                .numberAccountDestiny(entity.getCustomerAccountDestiny().getId())
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


