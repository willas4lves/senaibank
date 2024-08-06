package com.senaibank.senaibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.senaibank.classes.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

    void save(String contaOrigem);
}
