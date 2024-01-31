package com.penz.bank.service.impl;

import com.penz.bank.domain.*;
import com.penz.bank.dto.CreditCardDTO;
import com.penz.bank.mapper.AccountMapper;
import com.penz.bank.mapper.CreditCardMapper;
import com.penz.bank.repository.BranchRepository;
import com.penz.bank.repository.ClientRepository;
import com.penz.bank.repository.CreditCardRepository;
import com.penz.bank.repository.GlobalRateRepository;
import com.penz.bank.service.CreditCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final ClientRepository clientRepository;
    private final BranchRepository branchRepository;
    private final GlobalRateRepository globalRateRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository, ClientRepository clientRepository, BranchRepository branchRepository, GlobalRateRepository globalRateRepository) {
        this.creditCardRepository = creditCardRepository;
        this.clientRepository = clientRepository;
        this.branchRepository = branchRepository;
        this.globalRateRepository = globalRateRepository;
    }

    @Override
    public CreditCardDTO saveNewCreditCard(CreditCardDTO creditCardDTO) throws Exception {
        if (creditCardDTO == null) {
            throw new Exception("Credita card null");
        }

        if (creditCardDTO.getCardNumber() == null || creditCardDTO.getCardNumber().isEmpty()) {
            throw new Exception("Credit card number empty");
        }

        if (creditCardDTO.getCardState() == null || creditCardDTO.getCardState().isEmpty()) {
            throw new Exception("Card state number empty");
        }

        if (creditCardDTO.getOpeningDate() == null) {
            throw new Exception("Opening date empty");
        }

        if (creditCardDTO.getCreditLimit() == null || creditCardDTO.getCreditLimit() < 0) {
            throw new Exception("Credit limit empty or not available");
        }

        if (creditCardDTO.getDebt() == null || creditCardDTO.getDebt() < 0) {
            throw new Exception("Debt empty or not available");
        }

        if (creditCardDTO.getClientId() == null || creditCardDTO.getClientId() <= 0) {
            throw new Exception("Client ID empty or not valid");
        }

        if (creditCardDTO.getBranchId() == null || creditCardDTO.getBranchId() <= 0) {
            throw new Exception("Branch ID empty or not valid");
        }

        if (creditCardDTO.getGlobalRateId() == null || creditCardDTO.getGlobalRateId() <= 0) {
            throw new Exception("Global rate ID empty or not valid");
        }

        Optional<CreditCard> creditCardOptional = creditCardRepository.findCreditCardByCardNumber(creditCardDTO.getCardNumber());
        if (creditCardOptional.isPresent()) {
            throw new Exception(String.format("The card with number %s already exists", creditCardDTO.getCardNumber()));
        }

        Optional<Client> clientOptional = clientRepository.findById(creditCardDTO.getClientId());
        if (clientOptional.isEmpty()) {
            throw new Exception(String.format("There is not a client with id %d", creditCardDTO.getClientId()));
        }

        //Validate if the branch exists
        Optional<Branch> branchOptional = branchRepository.findById(creditCardDTO.getBranchId());
        if (branchOptional.isEmpty()) {
            throw new Exception(String.format("There is not a branch with id %d", creditCardDTO.getBranchId()));
        }

        //Validate if the global rate exists
        Optional<GlobalRate> globalRateOptional = globalRateRepository.findById(creditCardDTO.getGlobalRateId());
        if (globalRateOptional.isEmpty()) {
            throw new Exception(String.format("There is not a global rate with id %d", creditCardDTO.getGlobalRateId()));
        }


        CreditCard creditCard = CreditCardMapper.dtoToDomain(creditCardDTO);
        creditCard.setClient(clientOptional.get());
        creditCard.setBranch(branchOptional.get());
        creditCard.setGlobalRate(globalRateOptional.get());


        creditCard = creditCardRepository.save(creditCard);
        return CreditCardMapper.domainToDto(creditCard);
    }

    @Override
    public List<CreditCardDTO> searchAll() {
        return CreditCardMapper.domainToDtoList(creditCardRepository.findAll());
    }

    @Override
    public CreditCardDTO findByCardNumber(String cardNumber) throws Exception {
        // Validar que el número de cuenta no sea nulo o vacío
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new Exception("Account number is null or empty");
        }

        // Buscar la cuenta por número de cuenta
        Optional<CreditCard> creditCardOptional = creditCardRepository.findCreditCardByCardNumber(cardNumber);

        if (creditCardOptional.isPresent()) {
            // Mapear la cuenta a DTO y devolverla
            return CreditCardMapper.domainToDto(creditCardOptional.get());
        } else {
            // Lanzar una excepción si la cuenta no se encuentra
            throw new Exception(String.format("No credit card found with account number %s", cardNumber));
        }
    }
}
