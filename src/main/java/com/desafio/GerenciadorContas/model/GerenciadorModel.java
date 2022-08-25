package com.desafio.GerenciadorContas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "gerenciador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GerenciadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(length = 100,nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private Double valor;

    @Column(length = 50, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(length = 50)
    private LocalDateTime dataDePagamento;

    @Column(length = 50)
    private String status;

    @Column(length = 50)
    private String tipoConta;
}
