package com.senaibank.senaibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.senaibank.senaibank.classes.ContaBancaria;
import com.senaibank.senaibank.service.ContaBancariaService;
@RestController
@RequestMapping("/contas")
public class Contabancariacontroller {

    @Autowired
    private ContaBancariaService contaBankService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ContaBancaria contaBank) {
        return ResponseEntity.ok(contaBankService.create(contaBank));
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(contaBankService.findAll());
    }

    @GetMapping()
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return ResponseEntity.ok(contaBankService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ContaBancaria contaBank) {
        contaBank.setId(id);
        return ResponseEntity.ok(contaBankService.update(contaBank));
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contaBankService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
