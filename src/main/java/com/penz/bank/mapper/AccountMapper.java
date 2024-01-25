package com.penz.bank.mapper;

import com.penz.bank.domain.Account;
import com.penz.bank.dto.AccountDTO;

import java.util.List;

public class AccountMapper {
    public static Account dtoToDomain(AccountDTO accountDTO) {
        return Account.builder()
                .id(accountDTO.getId())
                .accType(accountDTO.getAccType())
                .accNumber(accountDTO.getAccNumber())
                .accState(accountDTO.getAccState())
                .openingDate(accountDTO.getOpeningDate())
                .cancellationDate(accountDTO.getCancellationDate())
                .availableAmount(accountDTO.getAvailableAmount())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public static AccountDTO domainToDto(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .accType(account.getAccType())
                .accNumber(account.getAccNumber())
                .accState(account.getAccState())
                .openingDate(account.getOpeningDate())
                .cancellationDate(account.getCancellationDate())
                .availableAmount(account.getAvailableAmount())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public List<Account> dtoToDomainList(List<AccountDTO> accountDTOS) {
        return accountDTOS.stream().map(AccountMapper::dtoToDomain).toList();
    }
}
