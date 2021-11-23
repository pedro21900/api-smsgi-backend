package com.example.apismsgibackend.domain.dto.impl;

import com.example.apismsgibackend.domain.dto.mapping.ProdutoMappingDTO;
import com.example.apismsgibackend.domain.Produto;
import com.example.apismsgibackend.domain.dto.ProdutoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMappingDTOImpl implements ProdutoMappingDTO {
    @Override
    public Produto toProduto(ProdutoDTO produtoDTO) {
        if (produtoDTO == null) {
            return null;
        }
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setValor(produtoDTO.getValor());

        return produto;
    }

    @Override
    public ProdutoDTO toProdutoDTO(Produto produto) {
        if (produto == null) {
            return null;
        }
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setValor(produto.getValor());

        return produtoDTO;
    }
}
