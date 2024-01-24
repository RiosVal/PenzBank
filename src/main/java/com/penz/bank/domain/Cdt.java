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
@Table(name = "cdts")
public class Cdt {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30, name = "cdtnumber")
    private String cdtNumber;

    @Column(nullable = false, length = 10, name = "cdtstate")
    private String cdtState;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false, name = "openingdate")
    private Date openingDate;

    @Column(nullable = false, name = "duedate")
    private Date dueDate;

    @Column(nullable = false)
    private Integer renovations;

    @Column(nullable = false, name = "investedamount")
    private Double investedAmount;

    @Column(nullable = false, name = "finalamount")
    private Double finalAmount;

    @ManyToOne
    @JoinColumn(name = "cdtowner_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @OneToOne
    @JoinColumn(name = "profitrate_id", referencedColumnName = "id", nullable = false)
    private GlobalRate globalRate;

    @ManyToOne
    @JoinColumn(name = "openingbranch_id", referencedColumnName = "id", nullable = false)
    private Branch branch;

}
