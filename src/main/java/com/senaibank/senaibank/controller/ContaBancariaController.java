package com.senaibank.senaibank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.senaibank.senaibank.classes.ContaBancaria;
import com.senaibank.senaibank.service.ContaBancariaService;
@RestController
@RequestMapping("contas")
public class Contabancariacontroller {

    @Autowired
    private ContaBancariaService contaBankService;

    @PostMapping
    public ResponseEntity<ContaBancaria> criarConta(@RequestBody ContaBancaria conta){
        ContaBancaria novaConta = contaBankService.create(conta);
        return ResponseEntity.ok(novaConta);
    }

    @GetMapping
    public ResponseEntity<List<ContaBancaria>> listadeContas(){
        List<ContaBancaria> contas = contaBankService.getAll();
        return ResponseEntity.ok(contas);
        
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> buscarContasPorId(@PathVariable Long id){
     ContaBancaria conta = contaBankService.getByid(id);
     if (conta == null) {
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ContaBancaria> atualizarConta(@PathVariable Long id, @RequestBody ContaBancaria contaAtualizada){
       ContaBancaria conta = contaBankService.getByid(id);
       if (conta == null) {
        return null;
        }
        conta.setSaldo(contaAtualizada.getSaldo());
        return ResponseEntity.ok(conta);

      
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long id){
       ContaBancaria conta = contaBankService.getByid(id);
       if (conta == null) {
        return ResponseEntity.notFound().build();
        
       }
       contaBankService.delete(id);
       return ResponseEntity.noContent().build();
    }
}
