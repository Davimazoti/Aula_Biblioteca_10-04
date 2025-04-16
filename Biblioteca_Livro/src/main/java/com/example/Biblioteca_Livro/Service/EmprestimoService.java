package com.example.Biblioteca_Livro.Service;

import com.example.Biblioteca_Livro.DTO.EmprestimoDTO;
import com.example.Biblioteca_Livro.Entity.Emprestimo;
import com.example.Biblioteca_Livro.Entity.Livro;
import com.example.Biblioteca_Livro.Repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    // Converte Emprestimo para EmprestimoDTO
    public EmprestimoDTO toDTO(Emprestimo emprestimo) {
        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        emprestimoDTO.setIdEmprestimo(emprestimo.getIdEmprestimo());
        emprestimoDTO.setDataInicial(emprestimo.getDatainicial());
        emprestimoDTO.setDataFinal(emprestimo.getDatafinal());
        emprestimoDTO.setCliente(emprestimo.getCliente());
        emprestimoDTO.setLivros(emprestimo.getLivroList());
        return emprestimoDTO;
    }

    // Converte EmprestimoDTO em Emprestimo
    public Emprestimo fromDTO(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDatainicial(emprestimoDTO.getDataInicial());
        emprestimo.setDatafinal(emprestimoDTO.getDataFinal());
        emprestimo.setCliente(emprestimoDTO.getCliente());
        emprestimo.setLivroList(emprestimoDTO.getLivros());
        return emprestimo;
    }

    public List<Emprestimo> getAll() {
        return emprestimoRepository.findAll();
    }

    // Buscar por ID
    public Optional<EmprestimoDTO> getById(Long id) {
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);

        if (optionalEmprestimo.isPresent()) {
            return Optional.of(this.toDTO(optionalEmprestimo.get()));
        } else {
            return Optional.empty();
        }
    }

    public EmprestimoDTO save(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = this.fromDTO(emprestimoDTO);
        Emprestimo emprestimoBd = emprestimoRepository.save(emprestimo);
        return this.toDTO(emprestimoBd);
    }

    public Optional<EmprestimoDTO> updateEmprestimo(Long id, EmprestimoDTO emprestimoDTO) {
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);

        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();

            emprestimo.setDatainicial(emprestimoDTO.getDataInicial());
            emprestimo.setDatafinal(emprestimoDTO.getDataFinal());

            Emprestimo emprestimoAtt = emprestimoRepository.save(emprestimo);

            return Optional.of(this.toDTO(emprestimoAtt));
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
