package com.biblioteca.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemEmprestimoDTO {
  private Long id;
  private LocalDate dataDevolucaoReal;
  private BigDecimal valorMulta;
  private String statusItem;
  private Long emprestimoId;
  private Long exemplarId;

  public ItemEmprestimoDTO() {
  }

  public ItemEmprestimoDTO(Long id, LocalDate dataDevolucaoReal, BigDecimal valorMulta, String statusItem,
        Long emprestimoId, Long exemplarId) {
    this.id = id;
    this.dataDevolucaoReal = dataDevolucaoReal;
    this.valorMulta = valorMulta;
    this.statusItem = statusItem;
    this.emprestimoId = emprestimoId;
    this.exemplarId = exemplarId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDataDevolucaoReal() {
    return dataDevolucaoReal;
  }

  public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
    this.dataDevolucaoReal = dataDevolucaoReal;
  }

  public BigDecimal getValorMulta() {
    return valorMulta;
  }

  public void setValorMulta(BigDecimal valorMulta) {
    this.valorMulta = valorMulta;
  }

  public String getStatusItem() {
    return statusItem;
  }

  public void setStatusItem(String statusItem) {
    this.statusItem = statusItem;
  }

  public Long getEmprestimoId() {
    return emprestimoId;
  }

  public void setEmprestimoId(Long emprestimoId) {
    this.emprestimoId = emprestimoId;
  }

  public Long getExemplarId() {
    return exemplarId;
  }

  public void setExemplarId(Long exemplarId) {
    this.exemplarId = exemplarId;
  }
  } 