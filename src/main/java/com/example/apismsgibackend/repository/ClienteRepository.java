package com.example.apismsgibackend.repository;

import com.example.apismsgibackend.domain.Cliente;
import com.example.apismsgibackend.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends  JpaRepository<Cliente,Long> ,JpaSpecificationExecutor<Cliente> {
}

