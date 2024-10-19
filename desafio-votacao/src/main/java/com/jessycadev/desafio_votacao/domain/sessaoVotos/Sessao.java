package com.jessycadev.desafio_votacao.domain.sessaoVotos;

import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "sessaoVotacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {

    @Id
    @GeneratedValue
    private UUID id;
    private String status;
    private String dataHora;

    @OneToMany
    @JoinColumn(name = "usuario_id")
    private Sessao sessaoVotacao;

}
