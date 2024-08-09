package com.senaibank.senaibank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senaibank.senaibank.classes.Transacao;
import com.senaibank.senaibank.repository.TransacaoRepository;

import java.util.*;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> getAll(){
        return transacaoRepository.findAll();
     }
     public Transacao getById(Long id){
        return transacaoRepository.findById(id).orElse(null);
     }
     public Transacao create(Transacao transacao){
        if( transacao.getContaOrigem().temSaldo(transacao.getValor()) ) {
       }
       return transacaoRepository.save(transacao);
    }

    public Transacao update(Long id, Transacao transacao){
        Transacao transacaoAtualizar = transacaoRepository.findById(id).orElse(null);
        if (transacaoAtualizar == null) {
            return null;
            }
            return transacaoRepository.save(transacaoAtualizar);
     }
     public void delete(Long id){
        transacaoRepository.deleteById(id);
    }
    public List<Transacao> getExtrato(Long idConta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExtrato'");
    }

}
