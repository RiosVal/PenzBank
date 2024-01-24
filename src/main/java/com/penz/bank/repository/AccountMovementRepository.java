package com.penz.bank.repository;

import com.penz.bank.domain.AccountMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountMovementRepository extends JpaRepository<AccountMovement, Integer> {
}
