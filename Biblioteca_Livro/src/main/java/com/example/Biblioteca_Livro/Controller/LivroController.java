package com.example.Biblioteca_Livro.Controller;

import com.example.Biblioteca_Livro.DTO.LivroDTO;
import com.example.Biblioteca_Livro.Entity.Livro;
import com.example.Biblioteca_Livro.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Livro>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<LivroDTO> getById(@PathVariable Long id) {
        Optional<LivroDTO> livroDTO = livroService.getById(id);

        if (livroDTO.isPresent()) {
            return ResponseEntity.ok(livroDTO.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<LivroDTO> create(@RequestBody LivroDTO livroDTO) {
        LivroDTO livroDTONew = livroService.save(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroDTONew);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        Optional<LivroDTO> dtoOptional = livroService.updateLivro(id, livroDTO);

        if (dtoOptional.isPresent()) {
            return ResponseEntity.ok(dtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (livroService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
