package com.example.apismsgibackend.repository;

import com.example.apismsgibackend.domain.Produto;
import com.example.apismsgibackend.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends  JpaRepository<Produto,Long> ,JpaSpecificationExecutor<Produto> {
    Boolean existsProdutoById(Long id);
}

