package com.penz.bank.service;

import com.penz.bank.dto.ClientDTO;

public interface ClientService {
    ClientDTO saveNewClient(ClientDTO clientDTO) throws Exception;
}
