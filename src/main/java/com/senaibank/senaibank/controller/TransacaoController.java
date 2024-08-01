package com.senaibank.senaibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senaibank.senaibank.classes.Transacao;
import com.senaibank.senaibank.service.TransacaoService;

import java.util.*;


@RestController
@RequestMapping("/transaçoes")
public class TransacaoController {


    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public Transacao realizarTransferencia(@RequestBody Transacao transacao) {
        return transacaoService.realizarTransferencia(transacao);
    }

    @GetMapping("/{numeroConta}")
    public List<Transacao> buscarHistoricoPorConta(@PathVariable Long numeroConta) {
        return transacaoService.buscarHistoricoPorConta(numeroConta);
    }




}
