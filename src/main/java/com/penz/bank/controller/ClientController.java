package com.penz.bank.controller;

import com.penz.bank.domain.Client;
import com.penz.bank.dto.ClientDTO;
import com.penz.bank.mapper.ClientMapper;
import com.penz.bank.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/get-all")
    public List<Client> getAll() { return clientRepository.findAll(); }

    @GetMapping("/searchId/{id}")
    public ResponseEntity<ClientDTO> searchForId(@PathVariable Integer id) throws Exception {
        Client client = clientRepository.getReferenceById(id);

        ClientDTO clientDTO = ClientMapper.domainToDto(client);

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }
}
