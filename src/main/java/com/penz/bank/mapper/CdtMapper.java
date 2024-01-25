package com.penz.bank.mapper;

import com.penz.bank.domain.Cdt;
import com.penz.bank.dto.CdtDTO;

import java.util.List;

public class CdtMapper {
    public static Cdt dtoToDomain(CdtDTO cdtDTO) {
        return Cdt.builder()
                .id(cdtDTO.getId())
                .cdtNumber(cdtDTO.getCdtNumber())
                .cdtState(cdtDTO.getCdtState())
                .term(cdtDTO.getTerm())
                .openingDate(cdtDTO.getOpeningDate())
                .dueDate(cdtDTO.getDueDate())
                .renovations(cdtDTO.getRenovations())
                .finalAmount(cdtDTO.getFinalAmount())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public CdtDTO domainToDto(Cdt cdt) {
        return CdtDTO.builder()
                .id(cdt.getId())
                .cdtNumber(cdt.getCdtNumber())
                .cdtState(cdt.getCdtState())
                .term(cdt.getTerm())
                .openingDate(cdt.getOpeningDate())
                .dueDate(cdt.getDueDate())
                .renovations(cdt.getRenovations())
                .finalAmount(cdt.getFinalAmount())
                //THERE ARE DEPENDENCIES
                .build();
    }

    public List<Cdt> dtoToDomainList(List<CdtDTO> cdtDTOS) {
        return  cdtDTOS.stream().map(CdtMapper::dtoToDomain).toList();
    }
}
