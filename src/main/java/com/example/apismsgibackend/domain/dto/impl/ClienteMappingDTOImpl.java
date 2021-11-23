package com.example.apismsgibackend.domain.dto.impl;

import com.example.apismsgibackend.domain.dto.mapping.ClienteMappingDTO;
import com.example.apismsgibackend.domain.Cliente;
import com.example.apismsgibackend.domain.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteMappingDTOImpl implements ClienteMappingDTO {
    @Override
    public Cliente toCliente(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpfCnpj(clienteDTO.getCpfCnpj());

        return cliente;
    }

    @Override
    public ClienteDTO toClienteDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setCpfCnpj(cliente.getCpfCnpj());

        return clienteDTO;
    }
}


