package com.penz.bank.mapper;

import com.penz.bank.domain.GlobalRate;
import com.penz.bank.dto.GlobalRateDTO;

import java.util.List;

public class GlobalRateMapper {

    public static GlobalRate dtoToDomain(GlobalRateDTO globalRateDTO) {
        return GlobalRate.builder()
                .id(globalRateDTO.getId())
                .product(globalRateDTO.getProduct())
                .ratePercentage(globalRateDTO.getRatePercentage())
                .productHandlingFee(globalRateDTO.getProductHandlingFee())
                .build();
    }

    public static GlobalRateDTO domainToDto(GlobalRate globalRate) {
        return GlobalRateDTO.builder()
                .id(globalRate.getId())
                .product(globalRate.getProduct())
                .ratePercentage(globalRate.getRatePercentage())
                .productHandlingFee(globalRate.getProductHandlingFee())
                .build();
    }

    public List<GlobalRate> domainToDtoList(List<GlobalRateDTO> globalRateDTOS) {
        return globalRateDTOS.stream().map(GlobalRateMapper::dtoToDomain).toList();
    }
}
