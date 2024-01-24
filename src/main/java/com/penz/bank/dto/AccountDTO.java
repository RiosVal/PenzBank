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
public class AccountDTO {
    private Integer id;
    private String accType;
    private String accNumber;
    private String accState;
    private Date openingDate;
    private Date cancellationDate;
    private Double availableAmount;
    private Integer clientId;
    private Integer branchId;
    private Integer globalRateId;
}
