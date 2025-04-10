package com.example.Biblioteca_Livro.Repository;

import com.example.Biblioteca_Livro.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
