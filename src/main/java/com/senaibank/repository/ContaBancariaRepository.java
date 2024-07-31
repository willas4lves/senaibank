package com.senaibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.classes.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

}
