package com.jessycadev.desafio_votacao.domain.sessao;

import java.util.UUID;
import com.jessycadev.desafio_votacao.domain.pauta.Pauta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "sessao")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String descricao;
    private String local;
    private String dataHora;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta Pauta;
}
