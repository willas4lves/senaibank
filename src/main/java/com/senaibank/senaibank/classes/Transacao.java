package com.senaibank.senaibank.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;


@Data
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "transacoes")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private double valor;
    
    @Column(nullable = false)
    @Enumerated
    private TipoTransacao tipoTransacao;

    

    @ManyToOne
    @JoinColumn(name = "conta_origem", referencedColumnName = "numero")
    private ContaBancaria contaOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_destino", referencedColumnName = "numero")
    private ContaBancaria contaDestino;
    

}
