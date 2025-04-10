package com.example.Biblioteca_Livro.Service;

import com.example.Biblioteca_Livro.DTO.ClienteDTO;
import com.example.Biblioteca_Livro.Entity.Cliente;
import com.example.Biblioteca_Livro.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // Converte Cliente para ClienteDTO
    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(cliente.getIdCliente());
        clienteDTO.setNomeCliente(cliente.getNomeCliente());
        clienteDTO.setSobrenome(cliente.getSobrenome());
        clienteDTO.setCpf(cliente.getCpf());

        return clienteDTO;
    }

    // Converte ClienteDTO em Cliente
    public Cliente fromDTO(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(clienteDTO.getNomeCliente());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setCpf(clienteDTO.getCpf());

        return cliente;
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    // Buscar por ID
    public Optional<ClienteDTO> getById(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            return Optional.of(this.toDTO(optionalCliente.get()));
        } else {
            return Optional.empty();
        }
    }

    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = this.fromDTO(clienteDTO);
        Cliente clienteBd = clienteRepository.save(cliente);

        return this.toDTO(clienteBd);
    }

    public Optional<ClienteDTO> updateCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();

            cliente.setNomeCliente(clienteDTO.getNomeCliente());
            cliente.setSobrenome(clienteDTO.getSobrenome());
            cliente.setCpf(clienteDTO.getCpf());

            Cliente clienteAtt = clienteRepository.save(cliente);

            return Optional.of(this.toDTO(clienteAtt));
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Método adicional para buscar por CPF
//    public Optional<ClienteDTO> getByCpf(String cpf) {
//        Optional<Cliente> optionalCliente = clienteRepository.findByCpf(cpf);
//
//        if (optionalCliente.isPresent()) {
//            return Optional.of(this.toDTO(optionalCliente.get()));
//        } else {
//            return Optional.empty();
//        }
//    }
}