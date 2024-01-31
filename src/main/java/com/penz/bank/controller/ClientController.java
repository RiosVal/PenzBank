package com.penz.bank.controller;

import com.penz.bank.domain.Client;
import com.penz.bank.dto.ClientDTO;
import com.penz.bank.mapper.ClientMapper;
import com.penz.bank.repository.ClientRepository;
import com.penz.bank.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/get-all")
    public List<Client> getAll() { return clientRepository.findAll(); }

    @GetMapping("/searchId/{id}")
    public ResponseEntity<ClientDTO> searchById(@PathVariable Integer id) throws Exception {
        Client client = clientRepository.getReferenceById(id);

        ClientDTO clientDTO = ClientMapper.domainToDto(client);

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @GetMapping("/searchByCedula/{cedula}")
    public ResponseEntity<ClientDTO> searchByCedula(@PathVariable String cedula) throws Exception{
        ClientDTO clientDTO = clientService.findByCedula(cedula);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @GetMapping("/searchByUsername/{username}")
    public ResponseEntity<ClientDTO> searchByUsername(@PathVariable String username) throws Exception{
        ClientDTO clientDTO = clientService.findByUsername(username);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) throws Exception{
        ClientDTO clientDTO1 = clientService.saveNewClient(clientDTO);
        return new ResponseEntity<>(clientDTO1, HttpStatus.OK);
    }

}
