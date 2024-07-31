package com.senaibank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senaibank.classes.ContaBancaria;
import com.senaibank.repository.ContaBancariaRepository;
import java.util.List;

@Service
public class ContaBancariaService {
    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public ContaBancaria criarContaBancaria(ContaBancaria contaBancaria){
        return contaBancariaRepository.save(contaBancaria);
    }

    public List<ContaBancaria> buscarTodasContas(){
        return contaBancariaRepository.findAll();
    }

    public ContaBancaria buscarContaPorNumero(Long numero) {
        return contaBancariaRepository.findById(numero).orElse(null);
    }

    public ContaBancaria atualizarConta(ContaBancaria contaBancaria) {
        return contaBancariaRepository.save(contaBancaria);
    }

    public void deletarConta(Long numero) {
        contaBancariaRepository.deleteById(numero);
    }

}
