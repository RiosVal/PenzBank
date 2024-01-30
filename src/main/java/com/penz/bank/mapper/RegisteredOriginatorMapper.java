package com.penz.bank.mapper;

import com.penz.bank.domain.RegisteredOriginator;
import com.penz.bank.dto.RegisteredOriginatorDTO;

import java.util.List;

public class RegisteredOriginatorMapper {

    public static RegisteredOriginator dtoToDomain(RegisteredOriginatorDTO registeredOriginatorDTO) {
        return RegisteredOriginator.builder()
                .id(registeredOriginatorDTO.getId())
                .cedula(registeredOriginatorDTO.getCedula())
                .nit(registeredOriginatorDTO.getNit())
                .fname(registeredOriginatorDTO.getFname())
                .lname(registeredOriginatorDTO.getLname())
                .accountNum(registeredOriginatorDTO.getAccountNum())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public static RegisteredOriginatorDTO domainToDto(RegisteredOriginator registeredOriginator) {
        return RegisteredOriginatorDTO.builder()
                .id(registeredOriginator.getId())
                .cedula(registeredOriginator.getCedula())
                .nit(registeredOriginator.getNit())
                .fname(registeredOriginator.getFname())
                .lname(registeredOriginator.getLname())
                .accountNum(registeredOriginator.getAccountNum())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public List<RegisteredOriginator> dtoToDomainList(List<RegisteredOriginatorDTO> registeredOriginatorDTOS){
        return registeredOriginatorDTOS.stream()
                .map(RegisteredOriginatorMapper::dtoToDomain)
                .toList();
    }
}
