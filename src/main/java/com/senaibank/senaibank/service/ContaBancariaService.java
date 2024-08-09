package com.senaibank.senaibank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senaibank.senaibank.classes.ContaBancaria;
import com.senaibank.senaibank.repository.ContaBancariaRepository;

import java.util.List;

@Service
public class ContaBancariaService {
    @Autowired
    private ContaBancariaRepository contaBankRepository;

    public ContaBancaria create(ContaBancaria contaBank) {
        return contaBankRepository.save(contaBank);
    }
    public ContaBancaria findById(Long id) {
        return contaBankRepository.findById(id).orElse(null);
    }

    public ContaBancaria atualizarConta(ContaBancaria contaBank , long id) {
        ContaBancaria contaAtualizar = getByid(id);
        if (contaAtualizar == null) {
            return null;
        }
        contaAtualizar.setSaldo(contaBank.getSaldo());
        return contaBankRepository.save(contaBank);
    }

    public void delete(Long id) {
        contaBankRepository.deleteById(id);
    }

    public List<ContaBancaria> getAll() {
        return contaBankRepository.findAll();
    }

    public ContaBancaria getByid(Long id) {
        return contaBankRepository.findById(id).orElse(null);
    }
    
}
