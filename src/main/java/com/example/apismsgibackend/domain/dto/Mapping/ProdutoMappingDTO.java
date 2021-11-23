package com.example.apismsgibackend.domain.dto.Mapping;

import com.example.apismsgibackend.domain.Produto;
import com.example.apismsgibackend.domain.dto.ProdutoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMappingDTO {

    Produto toProduto(ProdutoDTO produtoDTO);
    ProdutoDTO toProdutoDTO(Produto produto);
}
