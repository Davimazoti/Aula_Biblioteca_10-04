package com.example.Biblioteca_Livro.DTO;

import com.example.Biblioteca_Livro.Entity.Cliente;
import com.example.Biblioteca_Livro.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class EmprestimoDTO {
        private Long idEmprestimo;
        private Date data_Inicial;
        private Date data_Final;
        private Cliente cliente;
        private List<Livro> livros;
    }
