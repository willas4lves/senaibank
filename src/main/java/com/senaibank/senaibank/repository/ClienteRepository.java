package com.senaibank.senaibank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.senaibank.classes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findByAtivoTrue();

}
