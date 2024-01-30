package com.penz.bank.service.impl;

import com.penz.bank.domain.Account;
import com.penz.bank.domain.Branch;
import com.penz.bank.domain.Client;
import com.penz.bank.domain.GlobalRate;
import com.penz.bank.dto.AccountDTO;
import com.penz.bank.mapper.AccountMapper;
import com.penz.bank.repository.AccountRepository;
import com.penz.bank.repository.BranchRepository;
import com.penz.bank.repository.ClientRepository;
import com.penz.bank.repository.GlobalRateRepository;
import com.penz.bank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final BranchRepository branchRepository;
    private final GlobalRateRepository globalRateRepository;

    public AccountServiceImpl(
            AccountRepository accountRepository,
            ClientRepository clientRepository,
            BranchRepository branchRepository,
            GlobalRateRepository globalRateRepository
    ) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.branchRepository = branchRepository;
        this.globalRateRepository = globalRateRepository;
    }

    @Override
    public AccountDTO saveNewAccount(AccountDTO accountDTO) throws Exception {
        //1. Validate accounts data
        if (accountDTO == null) {
            throw new Exception("Account null");
        }

        if (accountDTO.getAccType() == null || accountDTO.getAccType().isEmpty()) {
            throw new Exception("Account type empty");
        }

        if (accountDTO.getAccNumber() == null || accountDTO.getAccNumber().isEmpty()){
            throw new Exception("Account number empty");
        }

        if (accountDTO.getAccState() == null || accountDTO.getAccState().isEmpty()){
            throw new Exception("Account state empty");
        }

        if (accountDTO.getOpeningDate() == null) {
            throw new Exception("Opening date empty");
        }

        if (accountDTO.getAvailableAmount() == null){
            throw new Exception("Available amount empty");
        }

        if (accountDTO.getClientId() == null || accountDTO.getClientId() == 0){
            throw new Exception("Client empty");
        }

        if (accountDTO.getBranchId() == null || accountDTO.getBranchId() == 0){
            throw new Exception("Branch empty");
        }

        if (accountDTO.getGlobalRateId() == null || accountDTO.getGlobalRateId() == 0){
            throw new Exception("Global rate empty");
        }

        //Validate if there is not an account with the same number
        Optional<Account> accountOptional = accountRepository.findByAccNumber(accountDTO.getAccNumber());
        if (accountOptional.isPresent()) {
            throw new Exception(String.format("The account with the number %s already exists", accountDTO.getAccNumber()));
        }

        //Validate if the client exists
        Optional<Client> clientOptional = clientRepository.findById(accountDTO.getClientId());
        if (clientOptional.isEmpty()) {
            throw new Exception(String.format("There is not a client with id %d", accountDTO.getClientId()));
        }

        //Validate if the branch exists
        Optional<Branch> branchOptional = branchRepository.findById(accountDTO.getBranchId());
        if (branchOptional.isEmpty()) {
            throw new Exception(String.format("There is not a branch with id %d", accountDTO.getBranchId()));
        }

        //Validate if the global rate exists
        Optional<GlobalRate> globalRateOptional = globalRateRepository.findById(accountDTO.getGlobalRateId());
        if (globalRateOptional.isEmpty()) {
            throw new Exception(String.format("There is not a global rate with id %d", accountDTO.getGlobalRateId()));
        }

        //2. Register account in DB mapping from DTO to DOMAIN
        Account account = AccountMapper.dtoToDomain(accountDTO);
        account.setClient(clientOptional.get());
        account.setBranch(branchOptional.get());
        account.setGlobalRate(globalRateOptional.get());


        //3. Return the account mapped in DTO
        account = accountRepository.save(account);
        return AccountMapper.domainToDto(account);
    }

    @Override
    public List<AccountDTO> searchAll() {
        return AccountMapper.domainToDtoList(accountRepository.findAll());
    }

    @Override
    public AccountDTO findByAccountNumber(String accNumber) throws Exception {
        // Validar que el número de cuenta no sea nulo o vacío
        if (accNumber == null || accNumber.isEmpty()) {
            throw new Exception("Account number is null or empty");
        }

        // Buscar la cuenta por número de cuenta
        Optional<Account> accountOptional = accountRepository.findByAccNumber(accNumber);

        if (accountOptional.isPresent()) {
            // Mapear la cuenta a DTO y devolverla
            return AccountMapper.domainToDto(accountOptional.get());
        } else {
            // Lanzar una excepción si la cuenta no se encuentra
            throw new Exception(String.format("No account found with account number %s", accNumber));
        }
    }

}
