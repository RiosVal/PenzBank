package com.penz.bank.repository;

import com.penz.bank.domain.RegisteredRecipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredRecipientRepository extends JpaRepository<RegisteredRecipient, Integer> {
}
