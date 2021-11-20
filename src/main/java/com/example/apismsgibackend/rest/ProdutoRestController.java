package com.example.apismsgibackend.rest;

import com.example.apismsgibackend.domain.Produto;
import com.example.apismsgibackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
//Implementar erro 404 getById e parâmetros de busca usando Page
@RestController
@RequestMapping("/api/produto")
public class ProdutoRestController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable() Long id) throws NoSuchElementException {
        return ResponseEntity.ok(produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado")));
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoRepository.save(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoRepository.save(produto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        ResponseEntity.ok();
    }
}
