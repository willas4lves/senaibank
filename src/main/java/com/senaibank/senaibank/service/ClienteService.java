package com.senaibank.senaibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senaibank.senaibank.repository.*;
import com.senaibank.senaibank.classes.Cliente;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Long id) {
        return clienteRepository.findById(id)
                                .orElse(null);
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Alternativa de escrever o update na camada de service
    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteExistente = getById(id);

        if (clienteExistente == null) {
            return null;
        }

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setTelefone(cliente.getTelefone());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setEndereco(cliente.getEndereco());
        clienteExistente.setDataNascimento(cliente.getDataNascimento());

        return clienteRepository.save(clienteExistente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}
