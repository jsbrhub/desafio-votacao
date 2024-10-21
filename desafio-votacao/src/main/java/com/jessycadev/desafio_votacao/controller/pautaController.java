package com.jessycadev.desafio_votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jessycadev.desafio_votacao.domain.pauta.Pauta;
import com.jessycadev.desafio_votacao.domain.pauta.PautaRequestDTO;
import com.jessycadev.desafio_votacao.service.PautaService;

@RestController
@RequestMapping("/api/pauta")
public class pautaController {
    
    @Autowired
    private PautaService pautaService;

     @PostMapping(consumes = "application/json")
     public ResponseEntity<Pauta> create(@RequestParam("nome") String nome ,
                                         @RequestParam("descricao") String descricao,
                                         @RequestParam("statusPauta") Boolean statusPauta) {
        PautaRequestDTO pautaRequestDTO = new PautaRequestDTO(nome, descricao, statusPauta);
        System.out.println(pautaRequestDTO);
        Pauta pauta = this.pautaService.createPauta(pautaRequestDTO);
        return ResponseEntity.ok(pauta);
    }
}
