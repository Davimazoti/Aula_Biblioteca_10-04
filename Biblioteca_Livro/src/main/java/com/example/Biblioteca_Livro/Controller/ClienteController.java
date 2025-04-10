package com.example.Biblioteca_Livro.Controller;

import com.example.Biblioteca_Livro.DTO.ClienteDTO;
import com.example.Biblioteca_Livro.Entity.Cliente;
import com.example.Biblioteca_Livro.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        Optional<ClienteDTO> clienteDTO = clienteService.getById(id);

        if (clienteDTO.isPresent()) {
            return ResponseEntity.ok(clienteDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteDTONew = clienteService.save(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTONew);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Optional<ClienteDTO> dtoOptional = clienteService.updateCliente(id, clienteDTO);

        if (dtoOptional.isPresent()) {
            return ResponseEntity.ok(dtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (clienteService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}