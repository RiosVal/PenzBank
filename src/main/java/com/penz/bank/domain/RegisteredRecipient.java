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
@Table(name = "registeredrecipients")
public class RegisteredRecipient {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String cedula;

    @Column(length = 20)
    private String nit;

    @Column(nullable = false, length = 30)
    private String fname;

    @Column(nullable = false, length = 30)
    private String lname;

    @Column(nullable = false, length = 30, name = "accountnum")
    private String accountNum;

    @OneToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id", nullable = false)
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "accassociated_id", referencedColumnName = "id", nullable = false)
    private Account accountAssociated;
}
