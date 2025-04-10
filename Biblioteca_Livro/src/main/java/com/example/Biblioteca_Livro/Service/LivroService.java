package com.example.Biblioteca_Livro.Service;

import com.example.Biblioteca_Livro.DTO.LivroDTO;
import com.example.Biblioteca_Livro.Entity.Livro;
import com.example.Biblioteca_Livro.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    // Converte Livro para LivroDTO
    public LivroDTO toDTO(Livro livro) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setIdLivro(livro.getIdLivro());
        livroDTO.setNomeLivro(livro.getNomeLivro());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setGenero(livro.getGenero());
        livroDTO.setISBN(livro.getISBN());
        return livroDTO;
    }

    // Converte LivroDTO em Livro
    public Livro fromDTO(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setNomeLivro(livroDTO.getNomeLivro());
        livro.setAutor(livroDTO.getAutor());
        livro.setGenero(livroDTO.getGenero());
        livro.setISBN(livroDTO.getISBN());
        return livro;
    }

    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    // Buscar por ID
    public Optional<LivroDTO> getById(Long id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if (optionalLivro.isPresent()) {
            return Optional.of(this.toDTO(optionalLivro.get()));
        } else {
            return Optional.empty();
        }
    }

    public LivroDTO save(LivroDTO livroDTO) {
        Livro livro = this.fromDTO(livroDTO);
        Livro livroBd = livroRepository.save(livro);
        return this.toDTO(livroBd);
    }

    public Optional<LivroDTO> updateLivro(Long id, LivroDTO livroDTO) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if (optionalLivro.isPresent()) {
            Livro livro = optionalLivro.get();

            livro.setNomeLivro(livroDTO.getNomeLivro());
            livro.setAutor(livroDTO.getAutor());
            livro.setGenero(livroDTO.getGenero());
            livro.setISBN(livroDTO.getISBN());

            Livro livroAtt = livroRepository.save(livro);
            return Optional.of(this.toDTO(livroAtt));
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
