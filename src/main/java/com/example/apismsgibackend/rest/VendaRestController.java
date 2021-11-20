package com.example.apismsgibackend.rest;

import com.example.apismsgibackend.domain.Venda;
import com.example.apismsgibackend.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
//Implementar erro 404 getById
@RestController
@RequestMapping("/api/venda")
public class VendaRestController {
    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping
    public ResponseEntity<List<Venda>> getAll() {
        return ResponseEntity.ok(vendaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getById(@PathVariable() Long id) throws NoSuchElementException {
        return ResponseEntity.ok(vendaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Venda não encontrada")));
    }

    @PostMapping
    public ResponseEntity<Venda> insert(@RequestBody Venda venda) {
        return ResponseEntity.ok(vendaRepository.save(venda));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable Long id, @RequestBody Venda venda) {
        return ResponseEntity.ok(vendaRepository.save(venda));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vendaRepository.deleteById(id);
        ResponseEntity.ok();
    }
}
