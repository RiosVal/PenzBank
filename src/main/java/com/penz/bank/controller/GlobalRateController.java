package com.penz.bank.controller;

import com.penz.bank.domain.GlobalRate;
import com.penz.bank.repository.GlobalRateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/global-rate")
public class GlobalRateController {

    private final GlobalRateRepository globalRateRepository;

    public GlobalRateController(GlobalRateRepository globalRateRepository) {
        this.globalRateRepository = globalRateRepository;
    }

    @GetMapping("/get-all")
    public List<GlobalRate> getAll() {
        return globalRateRepository.findAll();
    }
}
