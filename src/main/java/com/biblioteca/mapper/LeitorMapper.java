package com.biblioteca.mapper;

import com.biblioteca.dto.LeitorDTO;
import com.biblioteca.entity.Leitor;

public class LeitorMapper {
    public static LeitorDTO toDTO(Leitor leitor) {
        if (leitor == null) {
            return null;
        }
        return new LeitorDTO(
            leitor.getId(),
            leitor.getNome(),
            leitor.getEmail(),
            leitor.getTelefone()
        );
    }

public static Leitor toEntity(LeitorDTO leitorDTO) {
    if (leitorDTO == null) {
        return null;
    }
    return new Leitor(
        leitorDTO.getId(),
        leitorDTO.getNome(),
        leitorDTO.getEmail(),
        leitorDTO.getTelefone()
    );
}
}
