package com.penz.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {
    private Integer id;
    private String code;
    private String city;
    private String address;
    private String phoneNumber;
    private String branchType;
}
