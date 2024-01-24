package com.penz.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredDepositorDTO {
    private Integer id;
    private String cedula;
    private String fname;
    private String lname;
    private Integer accountAssociatedId;
}
