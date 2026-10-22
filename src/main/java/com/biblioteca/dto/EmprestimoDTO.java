package com.biblioteca.dto;

import java.time.LocalDate;

public class EmprestimoDTO {

    private Long id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private String status;
    private Long leitorId;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(Long id, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, String status, Long leitorId) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.status = status;
        this.leitorId = leitorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLeitorId() {
        return leitorId;
    }

    public void setLeitorId(Long leitorId) {
        this.leitorId = leitorId;
    }
}