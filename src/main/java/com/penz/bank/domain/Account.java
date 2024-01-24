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
@Table(name = "accounts")
public class Account {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 15, name = "acctype")
    private String accType;

    @Column(nullable = false, length = 20, name = "accnumber")
    private String accNumber;

    @Column(nullable = false, length = 10, name = "accstate")
    private String accState;

    @Column(nullable = false, name = "openingdate")
    private Date openingDate;

    @Column(name = "cancellationdate")
    private Date cancellationDate;

    @Column(nullable = false, name = "availableamount")
    private Double availableAmount;

    @ManyToOne
    @JoinColumn(name = "accowner_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "openingbranch_id", referencedColumnName = "id", nullable = false)
    private Branch branch;

    @OneToOne
    @JoinColumn(name = "rateandfee_id", referencedColumnName = "id", nullable = false)
    private GlobalRate globalRate;
}
