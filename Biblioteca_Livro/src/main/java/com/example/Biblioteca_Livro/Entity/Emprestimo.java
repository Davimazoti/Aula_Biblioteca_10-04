package com.example.Biblioteca_Livro.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate datainicial;
    private LocalDate datafinal;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;


    @ManyToMany
    @JoinTable(
            name = "emprestimoLivro",
            joinColumns = @JoinColumn(name = "idEmprestimo", referencedColumnName = "idEmprestimo"),
            inverseJoinColumns = @JoinColumn(name = "idLivro", referencedColumnName = "idLivro")
    )
    private List<Livro> livroList;
}
