package com.penz.bank.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CdtDTO {
    private Integer id;
    private String cdtNumber;
    private String cdtState;
    private Integer term;
    private Date openingDate;
    private Date dueDate;
    private Integer renovations;
    private Double investedAmount;
    private Double finalAmount;
    private Integer clientId;
    private Integer globalRateId;
    private Integer branchId;
}
