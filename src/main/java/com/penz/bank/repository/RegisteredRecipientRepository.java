package com.penz.bank.repository;

import com.penz.bank.domain.RegisteredRecipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisteredRecipientRepository extends JpaRepository<RegisteredRecipient, Integer> {
}
