package com.example.apismsgibackend.rest;

import com.example.apismsgibackend.domain.dto.impl.VendaMappingDTOImpl;
import com.example.apismsgibackend.domain.dto.VendaDTO;
import com.example.apismsgibackend.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/venda")
public class VendaRestController {
    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private VendaMappingDTOImpl vendaMappingDTOImpl;


    @GetMapping
    public ResponseEntity<List<VendaDTO>> getAll() {
        return ResponseEntity
                .ok(vendaRepository
                        .findAll()
                        .stream()
                        .map(x -> vendaMappingDTOImpl
                                .toVendaDTO(x))
                        .collect(Collectors
                                .toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDTO> getById(@PathVariable() Long id) {
        if (vendaRepository.existsVendaById(id)) {
            return ResponseEntity
                    .ok(vendaMappingDTOImpl
                            .toVendaDTO(
                                    vendaRepository.findById(id).get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<VendaDTO> insert(@RequestBody VendaDTO vendaDTO) throws ParseException {
        return ResponseEntity
                .ok(vendaMappingDTOImpl
                        .toVendaDTO(vendaRepository
                                .save(vendaMappingDTOImpl
                                        .toVenda(vendaDTO))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaDTO> update(@PathVariable Long id, @RequestBody VendaDTO vendaDTO) throws ParseException {
        if (vendaRepository.existsVendaById(id)) {
            return ResponseEntity
                    .ok(vendaMappingDTOImpl
                            .toVendaDTO(vendaRepository
                                    .save(vendaMappingDTOImpl
                                            .toVenda(vendaDTO))));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (vendaRepository.existsVendaById(id)) {
            vendaRepository.deleteById(id);
        } else {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
