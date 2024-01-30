package com.penz.bank.controller;

import com.penz.bank.domain.Account;
import com.penz.bank.dto.AccountDTO;
import com.penz.bank.mapper.AccountMapper;
import com.penz.bank.repository.AccountRepository;
import com.penz.bank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final AccountRepository accountRepository;

    public AccountController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDTO>> getAll() {
        return new ResponseEntity<>(accountService.searchAll(), HttpStatus.OK);
    }

    @GetMapping("/searchId/{id}")
    public ResponseEntity<AccountDTO> searchForId(@PathVariable Integer id) throws Exception {
        Account account = accountRepository.getReferenceById(id);
        AccountDTO accountDTO = AccountMapper.domainToDto(account);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @GetMapping("/searchByAccountNumber/{accNumber}")
    public ResponseEntity<AccountDTO> searchByAccountNumber(@PathVariable String accNumber) throws Exception {
        AccountDTO accountDTO = accountService.findByAccountNumber(accNumber);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO) throws Exception{
        AccountDTO accountDTO1 = accountService.saveNewAccount(accountDTO);
        return new ResponseEntity<>(accountDTO1, HttpStatus.OK);
    }
}
