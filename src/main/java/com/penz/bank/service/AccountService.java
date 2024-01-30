package com.penz.bank.service;

import com.penz.bank.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO saveNewAccount(AccountDTO accountDTO) throws Exception;
    List<AccountDTO> searchAll();
    AccountDTO findByAccountNumber(String accNumber) throws Exception;

}
