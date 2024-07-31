package com.senaibank.classes;

import jakarta.persistence.*;


@Entity
public class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private double saldo;

    @ManyToOne
    private Cliente cliente;

}
