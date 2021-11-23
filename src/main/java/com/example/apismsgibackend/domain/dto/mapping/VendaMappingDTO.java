package com.example.apismsgibackend.domain.dto.mapping;

import com.example.apismsgibackend.domain.Venda;
import com.example.apismsgibackend.domain.dto.VendaDTO;
import org.mapstruct.Mapper;

import java.text.ParseException;

@Mapper(componentModel = "spring")
public interface VendaMappingDTO {
    Venda toVenda(VendaDTO vendaDTO) throws ParseException;
    VendaDTO toVendaDTO(Venda venda);
}
