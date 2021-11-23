package com.example.apismsgibackend.rest;

import com.example.apismsgibackend.domain.dto.Impl.ProdutoMappingDTOImpl;
import com.example.apismsgibackend.domain.dto.ProdutoDTO;
import com.example.apismsgibackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//Implementar erro 404 getById e parâmetros de busca usando Page
@RestController
@RequestMapping("/api/produto")
public class ProdutoRestController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoMappingDTOImpl produtoMappingDTOImpl;


    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll() {
        return ResponseEntity
                .ok(produtoRepository
                        .findAll()
                        .stream()
                        .map(x -> produtoMappingDTOImpl
                                .toProdutoDTO(x))
                        .collect(Collectors
                                .toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable() Long id)  {
        if (produtoRepository.existsProdutoById(id)) {
            return ResponseEntity
                    .ok(produtoMappingDTOImpl
                            .toProdutoDTO(
                                    produtoRepository.findById(id).get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity
                .ok(produtoMappingDTOImpl
                        .toProdutoDTO(produtoRepository
                                .save(produtoMappingDTOImpl
                                        .toProduto(produtoDTO))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        if (produtoRepository.existsProdutoById(id)) {
            return ResponseEntity
                    .ok(produtoMappingDTOImpl
                            .toProdutoDTO(produtoRepository
                                    .save(produtoMappingDTOImpl
                                            .toProduto(produtoDTO))));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (produtoRepository.existsProdutoById(id)) {
            produtoRepository.deleteById(id);
        } else {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
