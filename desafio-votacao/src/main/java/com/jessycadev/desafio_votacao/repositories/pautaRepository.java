package com.jessycadev.desafio_votacao.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jessycadev.desafio_votacao.domain.pauta.Pauta;

public interface pautaRepository extends JpaRepository<Pauta, UUID>{

    
}