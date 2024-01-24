package com.penz.bank.repository;

import com.penz.bank.domain.Cdt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdtRepository extends JpaRepository<Cdt, Integer> {
}
