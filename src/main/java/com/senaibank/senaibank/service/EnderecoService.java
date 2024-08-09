package com.senaibank.senaibank.service;

import java.util.List;

import com.senaibank.senaibank.classes.Endereco;
import com.senaibank.senaibank.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
EnderecoRepository enderecoRepository;

    public List<Endereco> getAll() {
        // TODO Auto-generated method stub
        return enderecoRepository.findAll();
    }

    public Endereco getById(Long id){
        return enderecoRepository.findById(id).orElse(null);
    }
    public Endereco create(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
    public Endereco update(Endereco endereco, Long id){
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }
    public Endereco delete(Long id){
        Endereco endereco = getById(id);
        enderecoRepository.delete(endereco);
        return endereco;
    }

}
