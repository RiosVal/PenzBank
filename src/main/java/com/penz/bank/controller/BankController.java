package com.penz.bank.controller;

import com.penz.bank.domain.Bank;
import com.penz.bank.dto.BankDTO;
import com.penz.bank.mapper.BankMapper;
import com.penz.bank.repository.BankRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankRepository bankRepository;

    public BankController(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @GetMapping("/getAll")
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    @GetMapping("/searchId/{id}")
    public ResponseEntity<BankDTO> searchForId(@PathVariable Integer id) throws Exception {
        Bank bank = bankRepository.getReferenceById(id);

        BankDTO bankDTO = BankMapper.domainToDto(bank);

        return new ResponseEntity<>(bankDTO, HttpStatus.OK);
    }
}
