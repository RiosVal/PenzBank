package com.penz.bank.mapper;

import com.penz.bank.domain.RegisteredRecipient;
import com.penz.bank.dto.RegisteredRecipientDTO;

import java.util.List;

public class RegisteredRecipientMapper {

    public static RegisteredRecipient dtoToDomain(RegisteredRecipientDTO registeredRecipientDTO) {
        return RegisteredRecipient.builder()
                .id(registeredRecipientDTO.getId())
                .cedula(registeredRecipientDTO.getCedula())
                .nit(registeredRecipientDTO.getNit())
                .fname(registeredRecipientDTO.getFname())
                .lname(registeredRecipientDTO.getLname())
                .accountNum(registeredRecipientDTO.getAccountNum())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public static RegisteredRecipientDTO domainToDto(RegisteredRecipient registeredRecipient) {
        return RegisteredRecipientDTO.builder()
                .id(registeredRecipient.getId())
                .cedula(registeredRecipient.getCedula())
                .nit(registeredRecipient.getNit())
                .fname(registeredRecipient.getFname())
                .lname(registeredRecipient.getLname())
                .accountNum(registeredRecipient.getAccountNum())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public List<RegisteredRecipient> dtoToDomainList(List<RegisteredRecipientDTO> registeredRecipientDTOS) {
        return registeredRecipientDTOS.stream()
                .map(RegisteredRecipientMapper::dtoToDomain)
                .toList();
    }
}
