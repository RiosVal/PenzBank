package com.penz.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String cedula;

    @Column(nullable = false, length = 30)
    private String fname;

    @Column(nullable = false, length = 30)
    private String lname;

    @Column(nullable = false, length = 30, name = "phonenumber")
    private String phoneNumber;

    @Column(nullable = false, length = 60)
    private String address;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;
}
