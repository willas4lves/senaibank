package com.senaibank.senaibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.senaibank.classes.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
