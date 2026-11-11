package com.biblioteca.service;

import com.biblioteca.dto.LivroDTO;
import com.biblioteca.entity.Livro;
import com.biblioteca.mapper.LivroMapper;
import com.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroDTO> listarTodos() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream()
                .map(LivroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LivroDTO buscarPorId(Long id) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        Livro livro = livroOpt.orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));
        return LivroMapper.toDTO(livro);
    }

    public LivroDTO salvar(LivroDTO livroDTO) {
        Livro livro = LivroMapper.toEntity(livroDTO);
        livro = livroRepository.save(livro);
        return LivroMapper.toDTO(livro);
    }

    public void deletar(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível excluir. Livro não encontrado com o ID: " + id);
        }
        livroRepository.deleteById(id);
    }
}