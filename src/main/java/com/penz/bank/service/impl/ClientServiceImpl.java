package com.penz.bank.service.impl;

import com.penz.bank.domain.Client;
import com.penz.bank.dto.ClientDTO;
import com.penz.bank.mapper.ClientMapper;
import com.penz.bank.repository.ClientRepository;
import com.penz.bank.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO saveNewClient(ClientDTO clientDTO) throws Exception {
        //1. Validate clients data
        if (clientDTO == null) {
            throw new Exception("The client is null");
        }

        if (clientDTO.getCedula() == null || clientDTO.getCedula().isEmpty()) {
            throw new Exception("Cedula empty");
        }

        if (clientDTO.getFname() == null || clientDTO.getFname().isEmpty()) {
            throw new Exception("First name empty");
        }

        if (clientDTO.getLname() == null || clientDTO.getLname().isEmpty()) {
            throw new Exception("Last name empty");
        }

        if (clientDTO.getPhoneNumber() == null || clientDTO.getPhoneNumber().isEmpty()) {
            throw new Exception("Phone number empty");
        }

        if (clientDTO.getAddress() == null || clientDTO.getAddress().isEmpty()) {
            throw new Exception("Address empty");
        }

        if (clientDTO.getBirthdate() == null) {
            throw new Exception("Birthdate empty");
        }

        if (clientDTO.getUsername() == null || clientDTO.getUsername().isEmpty()) {
            throw new Exception("Username empty");
        }

        if (clientDTO.getPassword() == null || clientDTO.getPassword().isEmpty()) {
            throw new Exception("Password empty");
        }

        //Validate that there is no client with the same cedula
        Optional<Client> clientByCedula = clientRepository.findClientByCedula(clientDTO.getCedula());

        if(clientByCedula.isPresent()) {
            throw new Exception(String.format("Client with cedula %s is already registered", clientDTO.getCedula()));
        }

        //2. Register client in DB mapping from DTO to DOMAIN
        Client client = ClientMapper.dtoToDomain(clientDTO);
        client = clientRepository.save(client);


        //3. Return the client mapped in DTO
        clientDTO = ClientMapper.domainToDto(client);
        return clientDTO;

    }
}
