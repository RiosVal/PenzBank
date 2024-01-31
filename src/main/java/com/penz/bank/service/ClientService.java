package com.penz.bank.service;

import com.penz.bank.dto.ClientDTO;

public interface ClientService {
    ClientDTO saveNewClient(ClientDTO clientDTO) throws Exception;

    ClientDTO findByCedula(String cedula) throws Exception;

    ClientDTO findByUsername(String username) throws Exception;
}
