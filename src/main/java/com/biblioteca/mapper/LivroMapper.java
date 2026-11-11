package com.biblioteca.mapper;

import com.biblioteca.dto.LivroDTO;
import com.biblioteca.entity.Livro;

public class LivroMapper {
    public static LivroDTO toDTO(Livro livro) {
        if (livro == null) {
            return null;
    }
    return new LivroDTO(
        livro.getId(),
        livro.getTitulo(),
        livro.getAutor(),
        livro.getEditora(),
        livro.getIsbn()
    );
}

public static  Livro toEntity(LivroDTO livroDTO) {
    if (livroDTO == null) {
        return null;   
    }
    return  new  Livro(
        livroDTO.getId(),
        livroDTO.getTitulo(),
        livroDTO.getAutor(),
        livroDTO.getEditora(),
        livroDTO.getIsbn()  
    );
}
}