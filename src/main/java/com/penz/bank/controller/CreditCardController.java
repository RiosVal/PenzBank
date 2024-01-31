package com.penz.bank.controller;

import com.penz.bank.dto.AccountDTO;
import com.penz.bank.dto.CreditCardDTO;
import com.penz.bank.service.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {
    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreditCardDTO>> getAll() {
        return new ResponseEntity<>(creditCardService.searchAll(), HttpStatus.OK);
    }

    @GetMapping("/searchByCardNumber/{cardNumber}")
    public ResponseEntity<CreditCardDTO> searchByCardNumber(@PathVariable String cardNumber) throws Exception {
        CreditCardDTO creditCardDTO = creditCardService.findByCardNumber(cardNumber);
        return new ResponseEntity<>(creditCardDTO, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<CreditCardDTO> saveCreditCard(@RequestBody CreditCardDTO creditCardDTO) throws Exception{
        CreditCardDTO creditCardDTO1 = creditCardService.saveNewCreditCard(creditCardDTO);
        return new ResponseEntity<>(creditCardDTO1, HttpStatus.OK);
    }
}
