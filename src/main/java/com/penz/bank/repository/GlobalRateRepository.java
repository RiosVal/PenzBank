package com.penz.bank.repository;

import com.penz.bank.domain.GlobalRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalRateRepository extends JpaRepository<GlobalRate, Integer> {
}
