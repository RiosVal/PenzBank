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
@Table(name = "creditcards")
public class CreditCard {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30, name = "cardnumber")
    private String cardNumber;

    @Column(nullable = false, length = 10, name = "cardstate")
    private String cardState;

    @Column(nullable = false, name = "openingdate")
    private Date openingDate;

    @Column(name = "cancellationdate")
    private Date cancellationDate;

    @Column(nullable = false, name = "creditlimit")
    private Double creditLimit;

    @Column(nullable = false)
    private Double debt;

    @ManyToOne
    @JoinColumn(name = "cardowner_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "openingbranch_id", referencedColumnName = "id", nullable = false)
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "rateandfee_id", referencedColumnName = "id", nullable = false)
    private GlobalRate globalRate;
}
