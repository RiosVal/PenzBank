package com.penz.bank.repository;

import com.penz.bank.domain.RegisteredOriginator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredOriginatorRepository extends JpaRepository<RegisteredOriginator, Integer> {
}
