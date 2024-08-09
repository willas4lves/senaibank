package com.senaibank.senaibank.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senaibank.senaibank.repository.ClienteRepository;
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

    public List<Cliente> getAllAtivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAtivos'");
    }

    public Cliente atualizarCliente(Cliente clienteSalvo, Cliente clienteNovo) {
        // TODO Auto-generated method stub
        if (clienteNovo.getNome() != null) {
            clienteSalvo.setNome(clienteNovo.getNome());
        }
        if (clienteNovo.getCpf() != null) {
            clienteSalvo.setCpf(clienteNovo.getCpf());
        }
        if (clienteNovo.getTelefone() != null) {
            clienteSalvo.setTelefone(clienteNovo.getTelefone());
        }
        if (clienteNovo.getDataNascimento() != null) {
            clienteSalvo.setDataNascimento(clienteNovo.getDataNascimento());
        }
        if (clienteNovo.getEndereco() != null) {
            clienteSalvo.setEndereco(clienteNovo.getEndereco());
        }
        if (clienteNovo.getEmail() != null) {
            clienteSalvo.setEmail(clienteNovo.getEmail());  
        }
        if (clienteNovo.isAtivo() == false) {
            clienteSalvo.setAtivo(false);
        }

        return clienteRepository.save(clienteSalvo);
    }
    public Cliente delete(Long id) {
        
        // clienteRepository.deleteById(id);

        Cliente cliente = getById(id);

        Cliente clienteInativo = new Cliente();
        clienteInativo.setAtivo(false);

        return atualizarCliente(cliente, clienteInativo);

    }
}
