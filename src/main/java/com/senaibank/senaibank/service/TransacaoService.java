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

    public Transacao realizarTransferencia(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> buscarHistoricoPorConta(Long numeroConta) {
        return transacaoRepository.findAll();
    }

}
