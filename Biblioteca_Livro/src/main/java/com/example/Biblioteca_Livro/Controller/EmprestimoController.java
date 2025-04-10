package com.example.Biblioteca_Livro.Controller;

import com.example.Biblioteca_Livro.DTO.EmprestimoDTO;
import com.example.Biblioteca_Livro.Entity.Emprestimo;
import com.example.Biblioteca_Livro.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Emprestimo>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.getAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<EmprestimoDTO> getById(@PathVariable Long id) {
        Optional<EmprestimoDTO> emprestimoDTO = emprestimoService.getById(id);

        if (emprestimoDTO.isPresent()) {
            return ResponseEntity.ok(emprestimoDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<EmprestimoDTO> create(@RequestBody EmprestimoDTO emprestimoDTO) {
        EmprestimoDTO novoEmprestimo = emprestimoService.save(emprestimoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEmprestimo);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EmprestimoDTO> update(@PathVariable Long id, @RequestBody EmprestimoDTO emprestimoDTO) {
        Optional<EmprestimoDTO> dtoOptional = emprestimoService.updateEmprestimo(id, emprestimoDTO);

        if (dtoOptional.isPresent()) {
            return ResponseEntity.ok(dtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (emprestimoService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}