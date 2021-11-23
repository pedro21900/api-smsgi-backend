package com.example.apismsgibackend.domain.dto.impl;

import com.example.apismsgibackend.domain.dto.mapping.VendaMappingDTO;
import com.example.apismsgibackend.domain.Venda;
import com.example.apismsgibackend.domain.dto.VendaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class VendaMappingDTOImpl implements VendaMappingDTO {
    @Autowired
    private ClienteMappingDTOImpl clienteMappingDTOImpl;
    @Autowired
    private ProdutoMappingDTOImpl produtoMappingDTOImpl;

    private String converDateSum(String data) {
        String[] array = data
                .split("/");
        Integer dia = Integer
                .parseInt(array[0]) + 10;
        array[0] = dia
                .toString();
        return String
                .join("/", array);
    }

    @Override
    public Venda toVenda(VendaDTO vendaDTO) throws ParseException {
        if (vendaDTO == null) {
            return null;
        }
        Venda venda = new Venda();
        Date data = new SimpleDateFormat("dd/MM/yyyy")
                .parse(converDateSum(vendaDTO
                        .getData()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = dateFormat
                .format(data);
        Date data2 = new SimpleDateFormat("yyyy-MM-dd")
                .parse(dataFormatada);
        venda
                .setId(vendaDTO.getId());
        venda
                .setData(data2);
        venda
                .setCliente(clienteMappingDTOImpl
                        .toCliente(vendaDTO
                                .getCliente()));
        venda.setProduto(produtoMappingDTOImpl
                .toProduto(vendaDTO
                        .getProduto()));

        return venda;
    }

    @Override
    public VendaDTO toVendaDTO(Venda venda) {
        if (venda == null) {
            return null;
        }
        VendaDTO vendaDTO = new VendaDTO();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat
                .format(venda.getData());
        vendaDTO
                .setId(venda
                        .getId());
        vendaDTO
                .setData(dataFormatada);
        vendaDTO
                .setCliente(clienteMappingDTOImpl
                        .toClienteDTO(venda
                                .getCliente()));
        vendaDTO
                .setProduto(produtoMappingDTOImpl
                        .toProdutoDTO(venda
                                .getProduto()));
        return vendaDTO;
    }
}
