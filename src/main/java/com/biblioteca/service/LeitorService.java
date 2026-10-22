package com.biblioteca.service;

import com.biblioteca.dto.LeitorDTO;
import com.biblioteca.entity.Leitor;
import com.biblioteca.mapper.LeitorMapper;
import com.biblioteca.repository.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service 
public class LeitorService {

    @Autowired
    private LeitorRepository leitorRepository;

    public List<LeitorDTO> listarTodos() {
        List<Leitor> leitores = leitorRepository.findAll();
        return leitores.stream()
                .map(LeitorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LeitorDTO buscarPorId(Long id) {
        Optional<Leitor> leitorOpt = leitorRepository.findById(id);
        Leitor leitor = leitorOpt.orElseThrow(() -> new RuntimeException("Leitor não encontrado com o ID: " + id));
        return LeitorMapper.toDTO(leitor);
    }

    public LeitorDTO salvar(LeitorDTO leitorDTO) {
        Leitor leitor = LeitorMapper.toEntity(leitorDTO);
        leitor = leitorRepository.save(leitor);
        return LeitorMapper.toDTO(leitor);
    }

    public void deletar(Long id) {
        if (!leitorRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível excluir. Leitor não encontrado com o ID: " + id);
        }
        leitorRepository.deleteById(id);
    }
}