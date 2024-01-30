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
public class CreditCardDTO {
    private Integer id;
    private String cardNumber;
    private String cardState;
    private Date openingDate;
    private Date cancellationDate;
    private Double creditLimit;
    private Double debt;
    private Integer clientId;
    private Integer branchId;
    private Integer globalRateId;
}
