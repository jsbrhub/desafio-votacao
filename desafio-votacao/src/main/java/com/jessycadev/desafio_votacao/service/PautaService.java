package com.jessycadev.desafio_votacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jessycadev.desafio_votacao.domain.pauta.Pauta;
import com.jessycadev.desafio_votacao.domain.pauta.PautaRequestDTO;
import com.jessycadev.desafio_votacao.repositories.pautaRepository;

@Service
public class PautaService {

    @Autowired
    private pautaRepository repository;

    public Pauta createPauta(PautaRequestDTO data) {
        
        Pauta pauta = new Pauta();
        pauta.setNome(data.nome());
        pauta.setDescricao(data.descricao());
        pauta.setStatusPauta(data.statusPauta());

        repository.save(pauta);

        return pauta;
    }
}
