package com.penz.bank.repository;

import com.penz.bank.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    Optional<CreditCard> findCreditCardByCardNumber(String cardNumber);
}
