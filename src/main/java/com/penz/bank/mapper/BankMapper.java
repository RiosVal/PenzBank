package com.penz.bank.mapper;

import com.penz.bank.domain.Bank;
import com.penz.bank.dto.BankDTO;

import java.util.List;

public class BankMapper {
    public static Bank dtoToDomain(BankDTO bankDTO) {
        return Bank.builder()
                .id(bankDTO.getId())
                .bankName(bankDTO.getBankName())
                .build();
    }

    public BankDTO domainToDto(Bank bank) {
        return BankDTO.builder()
                .id(bank.getId())
                .bankName(bank.getBankName())
                .build();
    }

    public List<Bank> dtoToDomainList(List<BankDTO> bankDTOS) {
        return bankDTOS.stream().map(BankMapper::dtoToDomain).toList();
    }
}
