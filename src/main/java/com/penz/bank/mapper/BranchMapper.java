package com.penz.bank.mapper;

import com.penz.bank.domain.Branch;
import com.penz.bank.dto.BranchDTO;

import java.util.List;

public class BranchMapper {
    public static Branch dtoToDomain(BranchDTO branchDTO) {
        return Branch.builder()
                .id(branchDTO.getId())
                .code(branchDTO.getCode())
                .city(branchDTO.getCity())
                .address(branchDTO.getAddress())
                .phoneNumber(branchDTO.getPhoneNumber())
                .branchType(branchDTO.getBranchType())
                .build();
    }

    public static BranchDTO domainToDto(Branch branch) {
        return BranchDTO.builder()
                .id(branch.getId())
                .code(branch.getCode())
                .city(branch.getCity())
                .address(branch.getAddress())
                .phoneNumber(branch.getPhoneNumber())
                .branchType(branch.getBranchType())
                .build();
    }

    public List<Branch> dtoToDomainList(List<BranchDTO> branchDTOS) {
        return branchDTOS.stream().map(BranchMapper::dtoToDomain).toList();
    }
}
