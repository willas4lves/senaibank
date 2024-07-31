package com.senaibank.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.util.*;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@Table()
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private Date data;

    @ManyToOne
    private ContaBancaria contaOrigem;

    @ManyToOne
    private ContaBancaria contaDestino;

}
