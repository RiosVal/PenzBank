package com.penz.bank.repository;

import com.penz.bank.domain.RegisteredDepositor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredDepositorRepository extends JpaRepository<RegisteredDepositor, Integer> {
}
