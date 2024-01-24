package com.penz.bank.repository;

import com.penz.bank.domain.AccountMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMovementRepository extends JpaRepository<AccountMovement, Integer> {
}
