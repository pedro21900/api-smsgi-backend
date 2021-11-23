package com.example.apismsgibackend.repository;

import com.example.apismsgibackend.domain.Venda;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VendaRepository extends  JpaRepository<Venda,Long> {
    Boolean existsVendaById(Long id);
}

