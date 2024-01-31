package com.penz.bank.mapper;

import com.penz.bank.domain.CreditCard;
import com.penz.bank.dto.CreditCardDTO;

import java.util.List;

public class CreditCardMapper {
    public static CreditCard dtoToDomain(CreditCardDTO creditCardDTO) {
        return CreditCard.builder()
                .id(creditCardDTO.getId())
                .cardNumber(creditCardDTO.getCardNumber())
                .cardState(creditCardDTO.getCardState())
                .openingDate(creditCardDTO.getOpeningDate())
                .cancellationDate(creditCardDTO.getCancellationDate())
                .creditLimit(creditCardDTO.getCreditLimit())
                .debt(creditCardDTO.getDebt())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public static CreditCardDTO domainToDto(CreditCard creditCard) {
        return CreditCardDTO.builder()
                .id(creditCard.getId())
                .cardNumber(creditCard.getCardNumber())
                .cardState(creditCard.getCardState())
                .openingDate(creditCard.getOpeningDate())
                .cancellationDate(creditCard.getCancellationDate())
                .creditLimit(creditCard.getCreditLimit())
                .debt(creditCard.getDebt())
                .clientId((creditCard.getClient() == null) ?
                        null : creditCard.getClient().getId())
                .branchId((creditCard.getBranch() == null) ?
                        null : creditCard.getBranch().getId())
                .globalRateId((creditCard.getGlobalRate() == null) ?
                        null : creditCard.getGlobalRate().getId())
                .build();
    }

    public static List<CreditCardDTO> domainToDtoList(List<CreditCard> creditCards) {
        return creditCards.stream().map(CreditCardMapper::domainToDto).toList();
    }

    public List<CreditCard> dtoToDomainList(List<CreditCardDTO> creditCardDTOS){
        return creditCardDTOS.stream().map(CreditCardMapper::dtoToDomain).toList();
    }
}
