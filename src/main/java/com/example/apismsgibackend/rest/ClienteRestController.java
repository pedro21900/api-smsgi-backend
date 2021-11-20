package com.example.apismsgibackend.rest;

import com.example.apismsgibackend.domain.Cliente;
import com.example.apismsgibackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
//Implementar erro 404 getById e parâmetros de busca usando Page
@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable() Long id) throws NoSuchElementException {
        return ResponseEntity.ok(clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado")));
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        ResponseEntity.ok();
    }
}