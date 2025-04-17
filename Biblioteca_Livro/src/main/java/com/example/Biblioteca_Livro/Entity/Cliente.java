package com.example.Biblioteca_Livro.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nomeCliente;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Emprestimo> emprestimo;

    public Cliente (Long idCliente, String nomeCliente, String sobrenome, String cpf){
        this.idCliente =  idCliente;
        this.nomeCliente = nomeCliente;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
}
