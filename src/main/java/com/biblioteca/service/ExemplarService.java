package com.biblioteca.service;

import com.biblioteca.dto.ExemplarDTO;
import com.biblioteca.entity.Exemplar;
import com.biblioteca.entity.Livro;
import com.biblioteca.mapper.ExemplarMapper;
import com.biblioteca.repository.ExemplarRepository;
import com.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExemplarService {

    @Autowired
    private ExemplarRepository exemplarRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<ExemplarDTO> listarTodos() {
        List<Exemplar> exemplares = exemplarRepository.findAll();
        return exemplares.stream()
                .map(ExemplarMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ExemplarDTO buscarPorId(Long id) {
        Optional<Exemplar> exemplarOpt = exemplarRepository.findById(id);
        Exemplar exemplar = exemplarOpt.orElseThrow(() -> new RuntimeException("Exemplar não encontrado com o ID: " + id));
        return ExemplarMapper.toDTO(exemplar);
    }

    public ExemplarDTO salvar(ExemplarDTO exemplarDTO) {
        Livro livro = livroRepository.findById(exemplarDTO.getLivroId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + exemplarDTO.getLivroId()));

        Exemplar exemplar = ExemplarMapper.toEntity(exemplarDTO);
        exemplar.setLivro(livro);

        exemplar = exemplarRepository.save(exemplar);
        return ExemplarMapper.toDTO(exemplar);
    }

    public void deletar(Long id) {
        if (!exemplarRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível excluir. Exemplar não encontrado com o ID: " + id);
        }
        exemplarRepository.deleteById(id);
    }
}