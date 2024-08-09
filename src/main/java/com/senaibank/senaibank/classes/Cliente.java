package com.senaibank.senaibank.classes;


import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(length = 11)
    private String telefone;

    @Column(unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;


    @Column(name = "cliente_ativo", nullable = false)
    private boolean ativo = true;


}
