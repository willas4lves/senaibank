package com.senaibank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senaibank.classes.ContaBancaria;
import com.senaibank.service.ContaBancariaService;
import java.util.*;


@RestController
@RequestMapping("/contas")
public class ContaBancariaController {


    @Autowired
    private ContaBancariaService contaBancariaService;

    @PostMapping
    public ContaBancaria criarContaBancaria(@RequestBody ContaBancaria contaBancaria) {
        return contaBancariaService.criarContaBancaria(contaBancaria);
    }

    @GetMapping
    public List<ContaBancaria> buscarTodasContas() {
        return contaBancariaService.buscarTodasContas();
    }

    @GetMapping("/{numero}")
    public ContaBancaria buscarContaPorNumero(@PathVariable Long numero) {
        return contaBancariaService.buscarContaPorNumero(numero);
    }

    @PutMapping("/{numero}")
    public ContaBancaria atualizarConta(@PathVariable Long numero, @RequestBody ContaBancaria contaBancaria) {
        contaBancaria.setNumero(numero);
        return contaBancariaService.atualizarConta(contaBancaria);
    }

    @DeleteMapping("/{numero}")
    public void deletarConta(@PathVariable Long numero) {
        contaBancariaService.deletarConta(numero);
    }

}
