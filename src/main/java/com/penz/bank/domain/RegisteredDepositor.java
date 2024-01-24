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
@Table(name = "registereddepositors")
public class RegisteredDepositor {
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

    @ManyToOne
    @JoinColumn(name = "accassociated_id", referencedColumnName = "id", nullable = false)
    private Account accountAssociated;

}
