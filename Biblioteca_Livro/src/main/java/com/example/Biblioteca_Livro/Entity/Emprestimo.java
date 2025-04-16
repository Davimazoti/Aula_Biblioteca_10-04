package com.example.Biblioteca_Livro.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    private Date data_inicial;
    private Date data_final;


    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @JsonManagedReference
    private Cliente cliente;


    @ManyToMany
    @JoinTable(
            name = "emprestimoLivro",
            joinColumns = @JoinColumn(name = "emprestimoId"),
            inverseJoinColumns = @JoinColumn(name = "livroId")
    )
    private Set<Livro> livroList;
}
