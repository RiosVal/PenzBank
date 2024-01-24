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
@Table(name = "globalrates")

public class GlobalRate {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 40)
    private String product;

    @Column(nullable = false, name = "ratepercentage")
    private Double ratePercentage;

    @Column(nullable = false, name = "producthandlingfee")
    private Double productHandlingFee;

}
