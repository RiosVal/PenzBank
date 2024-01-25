package com.penz.bank.mapper;

import com.penz.bank.domain.RegisteredDepositor;
import com.penz.bank.dto.RegisteredDepositorDTO;

import java.util.List;

public class RegisteredDepositorMapper {
    public static RegisteredDepositor dtoToDomain(RegisteredDepositorDTO registeredDepositorDTO) {
        return RegisteredDepositor.builder()
                .id(registeredDepositorDTO.getId())
                .cedula(registeredDepositorDTO.getCedula())
                .fname(registeredDepositorDTO.getFname())
                .lname(registeredDepositorDTO.getLname())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public RegisteredDepositorDTO domainToDto(RegisteredDepositor registeredDepositor) {
        return RegisteredDepositorDTO.builder()
                .id(registeredDepositor.getId())
                .cedula(registeredDepositor.getCedula())
                .fname(registeredDepositor.getFname())
                .lname(registeredDepositor.getLname())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public List<RegisteredDepositor> dtoToDomainList(List<RegisteredDepositorDTO> registeredDepositorDTOS) {
        return registeredDepositorDTOS.stream()
                .map(RegisteredDepositorMapper::dtoToDomain).toList();
    }
}
