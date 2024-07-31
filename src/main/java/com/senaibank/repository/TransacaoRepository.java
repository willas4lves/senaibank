package com.senaibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.classes.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
