package com.example.Biblioteca_Livro.Repository;

import com.example.Biblioteca_Livro.Entity.Cliente;
import org.springdoc.core.providers.JavadocProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
