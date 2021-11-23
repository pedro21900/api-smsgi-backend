package com.example.apismsgibackend.domain.dto.mapping;

import com.example.apismsgibackend.domain.Cliente;
import com.example.apismsgibackend.domain.dto.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMappingDTO {
    Cliente toCliente(ClienteDTO clienteDTO);
    ClienteDTO toClienteDTO(Cliente cliente);
}
