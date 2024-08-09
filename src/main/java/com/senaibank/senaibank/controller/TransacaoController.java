package com.senaibank.senaibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> create(@RequestBody Transacao transacao){
        if( transacao.getContaOrigem().temSaldo(transacao.getValor()) ) {
            return ResponseEntity.ok(transacaoService.create(transacao));
        }
        return ResponseEntity.badRequest().body("Saldo insuficiente");
    }

    @GetMapping("/extrato/{id}")
    public ResponseEntity<List<Transacao>> getExtrato (@PathVariable Long idConta) {
        List<Transacao> extrato = transacaoService.getExtrato(idConta);
        
        if (extrato.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(extrato);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> getAll(){
        return ResponseEntity.ok(transacaoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getByid(@PathVariable Long id){
        return ResponseEntity.ok(transacaoService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> update(@PathVariable Long id, @RequestBody Transacao transacao){
        return ResponseEntity.ok(transacaoService.update(id, transacao));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        transacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
