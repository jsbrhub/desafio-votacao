package com.jessycadev.desafio_votacao.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import com.jessycadev.desafio_votacao.DTOS.PautaUpdateDTO;
import com.jessycadev.desafio_votacao.entity.Pauta;
import com.jessycadev.desafio_votacao.DTOS.PautaCreateDTO;
import com.jessycadev.desafio_votacao.DTOS.PautaDTO;
import com.jessycadev.desafio_votacao.service.PautaService;

@Controller
@RequestMapping("/api/pautas")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    // Listar todas as pautas
    @RequestMapping("/api/listarPautas")
    @GetMapping
    public List<PautaDTO> listarPautas() {
        return pautaService.listarPautas().stream()
                .map(pauta -> new PautaDTO(pauta.getId(), pauta.getTitulo(), pauta.getDescricao(), pauta.getStatus()))
                .collect(Collectors.toList());
    }

    // Criar uma nova pauta
    @PostMapping
    public ResponseEntity<PautaDTO> criarPauta(@Valid @RequestBody PautaCreateDTO pautaCreateDTO) {
        Pauta novaPauta = new Pauta();
        novaPauta.setTitulo(pautaCreateDTO.getTitulo());
        novaPauta.setDescricao(pautaCreateDTO.getDescricao());
        novaPauta.setStatus("Em andamento"); // Valor padrão

        Pauta salvaPauta = pautaService.criarPauta(novaPauta);
        PautaDTO pautaDTO = new PautaDTO(salvaPauta.getId(), salvaPauta.getTitulo(), salvaPauta.getDescricao(), salvaPauta.getStatus());

        return ResponseEntity.status(201).body(pautaDTO);
    }

    // Atualizar uma pauta
    @PutMapping("/{id}")
    public ResponseEntity<PautaDTO> atualizarPauta(@PathVariable Long id, @Valid @RequestBody PautaUpdateDTO pautaUpdateDTO) {
        Pauta pauta = pautaService.atualizarPauta(id, pautaUpdateDTO);
        if (pauta != null) {
            PautaDTO pautaDTO = new PautaDTO(pauta.getId(), pauta.getTitulo(), pauta.getDescricao(), pauta.getStatus());
            return ResponseEntity.ok(pautaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // Excluir uma pauta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPauta(@PathVariable Long id) {
        if (pautaService.excluirPauta(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
