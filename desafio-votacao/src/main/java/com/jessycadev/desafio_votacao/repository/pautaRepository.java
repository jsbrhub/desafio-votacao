package com.jessycadev.desafio_votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jessycadev.desafio_votacao.entity.Pauta;
import org.springframework.stereotype.Repository;

@Repository
public interface pautaRepository extends JpaRepository<Pauta, Long> {
   
}
