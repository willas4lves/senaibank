package com.senaibank.senaibank.classes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contas_bancarias")
public class ContaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private double saldo = 0.0;

    @OneToOne
    @JoinColumn(name = "conta_bancaria", referencedColumnName = "id")
    private Cliente cliente;

    

}
