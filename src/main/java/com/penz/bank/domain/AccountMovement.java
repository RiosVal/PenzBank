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
@Table(name = "accountmovements")
public class AccountMovement {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "transactiondate")
    private Date transactionDate;

    @Column(nullable = false, length = 15)
    private String type;

    @Column(nullable = false, length = 10)
    private String direction;

    @Column(nullable = false)
    private Double amount;

    @OneToOne
    @JoinColumn(name = "accinvolved_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @OneToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id")
    private RegisteredOriginator registeredOriginator;

    @OneToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private RegisteredRecipient registeredRecipient;

    @OneToOne
    @JoinColumn(name = "depositor_id", referencedColumnName = "id")
    private RegisteredDepositor registeredDepositor;
}
