package com.penz.bank.mapper;

import com.penz.bank.domain.Client;
import com.penz.bank.dto.ClientDTO;

import java.util.List;

public class ClientMapper {

    public static Client dtoToDomain(ClientDTO clientDTO) {
        return Client.builder()
                .id(clientDTO.getId())
                .cedula(clientDTO.getCedula())
                .fname(clientDTO.getFname())
                .lname(clientDTO.getLname())
                .phoneNumber(clientDTO.getPhoneNumber())
                .address(clientDTO.getAddress())
                .birthdate(clientDTO.getBirthdate())
                .username(clientDTO.getUsername())
                .password(clientDTO.getPassword())
                .build();
    }

    public static ClientDTO domainToDto(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .cedula(client.getCedula())
                .fname(client.getFname())
                .lname(client.getLname())
                .phoneNumber(client.getPhoneNumber())
                .address(client.getAddress())
                .birthdate(client.getBirthdate())
                .username(client.getUsername())
                .password(client.getPassword())
                .build();
    }

    public List<Client> dtoToDomainList(List<ClientDTO> clientDTOS) {
        return clientDTOS.stream().map(ClientMapper::dtoToDomain).toList();
    }
}
