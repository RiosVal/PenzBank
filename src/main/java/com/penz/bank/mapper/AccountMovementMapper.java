package com.penz.bank.mapper;

import com.penz.bank.domain.AccountMovement;
import com.penz.bank.dto.AccountMovementDTO;

import java.util.List;

public class AccountMovementMapper {

    public static AccountMovement dtoToDomain(AccountMovementDTO accountMovementDTO) {
        return AccountMovement.builder()
                .id(accountMovementDTO.getId())
                .transactionDate(accountMovementDTO.getTransactionDate())
                .type(accountMovementDTO.getType())
                .direction(accountMovementDTO.getDirection())
                .amount(accountMovementDTO.getAmount())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public static AccountMovementDTO domainToDto(AccountMovement accountMovement){
        return AccountMovementDTO.builder()
                .id(accountMovement.getId())
                .transactionDate(accountMovement.getTransactionDate())
                .type(accountMovement.getType())
                .direction(accountMovement.getDirection())
                .amount(accountMovement.getAmount())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public List<AccountMovement> dtoToDomainLIst(List<AccountMovementDTO> accountMovementDTOS){
        return accountMovementDTOS.stream().map(AccountMovementMapper::dtoToDomain).toList();
    }
}
