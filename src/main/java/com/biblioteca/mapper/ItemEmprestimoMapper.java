package com.biblioteca.mapper;

import com.biblioteca.dto.ItemEmprestimoDTO;
import com.biblioteca.entity.ItemEmprestimo;
import com.biblioteca.entity.Emprestimo;
import com.biblioteca.entity.Exemplar;

public class ItemEmprestimoMapper {

    public static ItemEmprestimoDTO toDTO(ItemEmprestimo item) {
        if (item == null) {
            return null;
        }
        ItemEmprestimoDTO dto = new ItemEmprestimoDTO();
        dto.setId(item.getId());
        dto.setDataDevolucaoReal(item.getDataDevolucaoReal());
        dto.setValorMulta(item.getValorMulta());
        dto.setStatusItem(item.getStatusItem());

        if (item.getEmprestimo() != null) {
            dto.setEmprestimoId(item.getEmprestimo().getId());
        }

        if (item.getExemplar() != null) {
            dto.setExemplarId(item.getExemplar().getId());
        }

        return dto;
    }

    public static ItemEmprestimo toEntity(ItemEmprestimoDTO dto) {
        if (dto == null) {
            return null;
        }
        ItemEmprestimo item = new ItemEmprestimo();
        item.setId(dto.getId());
        item.setDataDevolucaoReal(dto.getDataDevolucaoReal());
        item.setValorMulta(dto.getValorMulta());
        item.setStatusItem(dto.getStatusItem());

        if (dto.getEmprestimoId() != null) {
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setId(dto.getEmprestimoId());
            item.setEmprestimo(emprestimo);
        }

        if (dto.getExemplarId() != null) {
            Exemplar exemplar = new Exemplar();
            exemplar.setId(dto.getExemplarId());
            item.setExemplar(exemplar);
        }

        return item;
    }
}
