package com.penz.bank.controller;

import com.penz.bank.domain.GlobalRate;
import com.penz.bank.dto.GlobalRateDTO;
import com.penz.bank.mapper.GlobalRateMapper;
import com.penz.bank.repository.GlobalRateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/searchId/{id}")
    public ResponseEntity<GlobalRateDTO> searchForId(@PathVariable Integer id) throws Exception{
        GlobalRate globalRate = globalRateRepository.getReferenceById(id);
        GlobalRateDTO globalRateDTO = GlobalRateMapper.domainToDto(globalRate);
        return new ResponseEntity<>(globalRateDTO, HttpStatus.OK);
    }

}
