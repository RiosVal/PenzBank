package com.penz.bank.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String code;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 60)
    private String address;

    @Column(nullable = false, length = 30, name = "phonenumber")
    private String phoneNumber;

    @Column(nullable = false, length = 20, name = "branchtype")
    private String branchType;
}
