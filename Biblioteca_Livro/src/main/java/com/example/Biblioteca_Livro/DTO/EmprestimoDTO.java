package com.example.Biblioteca_Livro.DTO;

import com.example.Biblioteca_Livro.Entity.Cliente;
import com.example.Biblioteca_Livro.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class EmprestimoDTO {
        private Long idEmprestimo;
        private LocalDate dataInicial;
        private LocalDate dataFinal;
        private Cliente cliente;
        private Set<Livro> livros;
    }
