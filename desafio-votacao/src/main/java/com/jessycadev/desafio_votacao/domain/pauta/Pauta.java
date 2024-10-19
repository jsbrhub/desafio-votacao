package com.jessycadev.desafio_votacao.domain.pauta;

import java.util.UUID;

import com.jessycadev.desafio_votacao.domain.sessaoVotos.Sessao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pauta")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pauta {

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String descricao;
    private String local;
    private String dataHora;
    private Integer votos;

    @OneToOne
    @JoinColumn(name = "sessao_id")
    private Sessao sessao;

}