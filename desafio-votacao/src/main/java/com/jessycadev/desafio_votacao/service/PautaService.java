package com.jessycadev.desafio_votacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.jessycadev.desafio_votacao.DTOS.PautaUpdateDTO;
import com.jessycadev.desafio_votacao.repository.pautaRepository;
import com.jessycadev.desafio_votacao.entity.Pauta;

@Service
public class PautaService {

    @Autowired
    private pautaRepository pautaRepository;

    public List<Pauta> listarPautas() {
        return pautaRepository.findAll();
    }

    public Pauta criarPauta(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    public Pauta atualizarPauta(Long id, PautaUpdateDTO pautaUpdateDTO) {
        Optional<Pauta> pautaExistente = pautaRepository.findById(id);
        if (pautaExistente.isPresent()) {
            Pauta pauta = pautaExistente.get();
            pauta.setTitulo(pautaUpdateDTO.getTitulo());
            pauta.setDescricao(pautaUpdateDTO.getDescricao());
            pauta.setStatus(pautaUpdateDTO.getStatus());
            return pautaRepository.save(pauta);
        }
        return null; // ou lançar uma exceção
    }

    public boolean excluirPauta(Long id) {
        if (pautaRepository.existsById(id)) {
            pautaRepository.deleteById(id);
            return true;
        }
        return false; // ou lançar uma exceção
    }
}
