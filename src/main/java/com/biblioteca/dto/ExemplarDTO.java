package com.biblioteca.dto;

public class ExemplarDTO {

    private Long id;
    private String tombo;
    private Long livroId;

    public ExemplarDTO() {
    }

    public ExemplarDTO(Long id, String tombo, Long livroId) {
        this.id = id;
        this.tombo = tombo;
        this.livroId = livroId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTombo() {
        return tombo;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }
}