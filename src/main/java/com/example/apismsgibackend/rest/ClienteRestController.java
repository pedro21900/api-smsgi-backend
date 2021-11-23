package com.example.apismsgibackend.rest;

import com.example.apismsgibackend.domain.dto.Impl.ClienteMappingDTOImpl;
import com.example.apismsgibackend.domain.dto.ClienteDTO;
import com.example.apismsgibackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//Implementar erro 404 getById e parâmetros de busca usando Page
@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
    @Autowired
    private ClienteMappingDTOImpl clienteMappingDTOImpl;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return ResponseEntity
                .ok(clienteRepository
                        .findAll()
                        .stream()
                        .map(x -> clienteMappingDTOImpl
                                .toClienteDTO(x))
                        .collect(Collectors
                                .toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable() Long id)  {
        if (clienteRepository.existsClientesById(id)) {
            return ResponseEntity
                    .ok(clienteMappingDTOImpl
                            .toClienteDTO(clienteRepository.findById(id).get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity
                .ok(clienteMappingDTOImpl
                        .toClienteDTO(clienteRepository
                                .save(clienteMappingDTOImpl
                                        .toCliente(clienteDTO))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        if (clienteRepository.existsClientesById(id)) {
            return ResponseEntity
                    .ok(clienteMappingDTOImpl
                            .toClienteDTO(clienteRepository
                                    .save(clienteMappingDTOImpl
                                            .toCliente(clienteDTO))));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (clienteRepository.existsClientesById(id)) {
            clienteRepository.deleteById(id);
        } else {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}