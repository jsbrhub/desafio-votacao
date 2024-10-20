package com.jessycadev.desafio_votacao.domain.pauta;

import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pauta")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pauta {

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String descricao;
    private boolean statusPauta;


}