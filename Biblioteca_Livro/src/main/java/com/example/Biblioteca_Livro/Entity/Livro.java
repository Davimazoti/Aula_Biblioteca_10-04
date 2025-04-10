package com.example.Biblioteca_Livro.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    private String nomeLivro;
    private String autor;
    private String genero;

    @Column(unique = true)
    private String ISBN;

    @ManyToOne
    @JoinColumn(name = "idEmprestimo", referencedColumnName = "idEmprestimo")
    @JsonBackReference
    private Emprestimo emprestimo;



}
