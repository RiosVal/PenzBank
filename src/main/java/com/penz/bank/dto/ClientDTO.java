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
public class ClientDTO {
    private Integer id;
    private String cedula;
    private String fname;
    private String lname;
    private String phoneNumber;
    private String address;
    private Date birthdate;
    private String username;
    private String password;
}
