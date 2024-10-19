package com.jessycadev.desafio_votacao.DTOS;

public class PautaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String status;

    // Construtor
    public PautaDTO(Long id, String titulo, String descricao, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }
}
