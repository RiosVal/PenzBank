package com.penz.bank.controller;

import com.penz.bank.domain.Branch;
import com.penz.bank.dto.BranchDTO;
import com.penz.bank.mapper.BranchMapper;
import com.penz.bank.repository.BranchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchRepository branchRepository;

    public BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @GetMapping("/get-all")
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @GetMapping("/searchId/{id}")
    public ResponseEntity<BranchDTO> searchForId(@PathVariable Integer id) throws Exception {
        Branch branch = branchRepository.getReferenceById(id);

        BranchDTO branchDTO = BranchMapper.domainToDto(branch);

        return new ResponseEntity<>(branchDTO, HttpStatus.OK);
    }
}
