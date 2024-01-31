package com.penz.bank.service;

import com.penz.bank.domain.CreditCard;
import com.penz.bank.dto.CreditCardDTO;

import java.util.List;

public interface CreditCardService {
    CreditCardDTO saveNewCreditCard(CreditCardDTO creditCardDTO) throws Exception;
    List<CreditCardDTO> searchAll();
    CreditCardDTO findByCardNumber(String cardNumber) throws Exception;
}
