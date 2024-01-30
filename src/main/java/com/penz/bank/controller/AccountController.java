package com.penz.bank.controller;

import com.penz.bank.dto.AccountDTO;
import com.penz.bank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDTO>> getAll() {
        return new ResponseEntity<>(accountService.searchAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO) throws Exception{
        AccountDTO accountDTO1 = accountService.saveNewAccount(accountDTO);
        return new ResponseEntity<>(accountDTO1, HttpStatus.OK);
    }
}
