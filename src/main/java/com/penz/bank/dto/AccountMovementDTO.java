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
public class AccountMovementDTO {
    private Integer id;
    private Date transactionDate;
    private String type;
    private String direction;
    private Double amount;
    private Integer accountId;
    private Integer registeredOriginatorId;
    private Integer registeredRecipientId;
    private Integer registeredDepositorId;
}
