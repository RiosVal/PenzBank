package com.penz.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredOriginatorDTO {
    private Integer id;
    private String cedula;
    private String nit;
    private String fname;
    private String lname;
    private String accountNum;
    private Integer bankId;
    private Integer accountAssociatedId;
}
