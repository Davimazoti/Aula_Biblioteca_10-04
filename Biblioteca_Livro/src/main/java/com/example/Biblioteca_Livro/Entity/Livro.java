package com.example.Biblioteca_Livro.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    private String nomeLivro;
    private String autor;
    private String genero;

    @Column(unique = true)
    private String ISBN;

    @ManyToMany (mappedBy = "livroList")
    @JsonIgnore
    private Set<Emprestimo> emprestimo;

    public Livro(Long idLivro, String nomeLivro, String autor, String ISBN, String genero){
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
    }


}
