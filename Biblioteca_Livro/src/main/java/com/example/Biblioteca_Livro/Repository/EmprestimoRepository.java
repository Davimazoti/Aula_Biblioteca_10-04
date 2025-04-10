package com.example.Biblioteca_Livro.Repository;

import com.example.Biblioteca_Livro.Entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
