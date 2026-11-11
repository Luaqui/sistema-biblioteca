package com.biblioteca.mapper;

import com.biblioteca.dto.ExemplarDTO;
import com.biblioteca.entity.Exemplar;
import com.biblioteca.entity.Livro;

public class ExemplarMapper {

    public static ExemplarDTO toDTO(Exemplar exemplar) {
        if (exemplar == null) {
            return null;
        }
        Long livroId = (exemplar.getLivro() != null) ? exemplar.getLivro().getId() : null;
        return new ExemplarDTO(
            exemplar.getId(),
            exemplar.getTombo(),
            livroId
        );
    }

    public static Exemplar toEntity(ExemplarDTO dto) {
        if (dto == null) {
            return null;
        }
        Livro livro = null;
        if (dto.getLivroId() != null) {
            livro = new Livro();
            livro.setId(dto.getLivroId());
        }
        return new Exemplar(
            dto.getId(),
            dto.getTombo(),
            livro
        );
    }
}