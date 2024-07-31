package com.senaibank.classes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "id")
public class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private double saldo;

    @ManyToOne
    private Cliente cliente;

}
