package com.penz.bank.repository;

import com.penz.bank.domain.GlobalRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlobalRateRepository extends JpaRepository<GlobalRate, Integer> {
}
