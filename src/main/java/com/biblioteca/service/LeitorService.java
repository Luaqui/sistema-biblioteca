package com.biblioteca.service;

import com.biblioteca.dto.LeitorDTO;
import com.biblioteca.entity.Leitor;
import com.biblioteca.mapper.LeitorMapper;
import com.biblioteca.repository.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Leitor leitor = leitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leitor não encontrado com o ID: " + id));
        return LeitorMapper.toDTO(leitor);
    }

    public LeitorDTO salvar(LeitorDTO leitorDTO) {
        Leitor leitor = LeitorMapper.toEntity(leitorDTO);
        Leitor leitorSalvo = leitorRepository.save(leitor);
        return LeitorMapper.toDTO(leitorSalvo);
    }

    public LeitorDTO atualizar(Long id, LeitorDTO leitorDTO) {
        Leitor leitor = leitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leitor não encontrado com o ID: " + id));

        leitor.setNome(leitorDTO.getNome());
        leitor.setEmail(leitorDTO.getEmail());
        leitor.setTelefone(leitorDTO.getTelefone());

        Leitor leitorAtualizado = leitorRepository.save(leitor);
        return LeitorMapper.toDTO(leitorAtualizado);
    }

    public void deletar(Long id) {
        Leitor leitor = leitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leitor não encontrado com o ID: " + id));
        leitorRepository.delete(leitor);
    }
}