package com.example.Biblioteca_Livro.Service;

import com.example.Biblioteca_Livro.DTO.EmprestimoDTO;
import com.example.Biblioteca_Livro.Entity.Emprestimo;
import com.example.Biblioteca_Livro.Repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    // Converte Emprestimo para EmprestimoDTO
    public EmprestimoDTO toDTO(Emprestimo emprestimo) {
        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        emprestimoDTO.setIdEmprestimo(emprestimo.getIdEmprestimo());
        emprestimoDTO.setData_Inicial(emprestimo.getData_inicial());
        emprestimoDTO.setData_Final(emprestimo.getData_final());
        return emprestimoDTO;
    }

    // Converte EmprestimoDTO em Emprestimo
    public Emprestimo fromDTO(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setData_inicial(emprestimoDTO.getData_Inicial());
        emprestimo.setData_final(emprestimoDTO.getData_Final());
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

            emprestimo.setData_inicial(emprestimoDTO.getData_Inicial());
            emprestimo.setData_final(emprestimoDTO.getData_Final());

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
