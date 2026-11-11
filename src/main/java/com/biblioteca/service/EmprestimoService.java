package com.biblioteca.service;

import com.biblioteca.dto.EmprestimoDTO;
import com.biblioteca.entity.Emprestimo;
import com.biblioteca.entity.Leitor;
import com.biblioteca.mapper.EmprestimoMapper;
import com.biblioteca.repository.EmprestimoRepository;
import com.biblioteca.repository.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LeitorRepository leitorRepository;

    public List<EmprestimoDTO> listarTodos() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAll();
        return emprestimos.stream()
                .map(EmprestimoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmprestimoDTO buscarPorId(Long id) {
        Optional<Emprestimo> emprestimoOpt = emprestimoRepository.findById(id);
        Emprestimo emprestimo = emprestimoOpt.orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com o ID: " + id));
        return EmprestimoMapper.toDTO(emprestimo);
    }

    public EmprestimoDTO salvar(EmprestimoDTO emprestimoDTO) {
        Leitor leitor = leitorRepository.findById(emprestimoDTO.getLeitorId())
                .orElseThrow(() -> new RuntimeException("Leitor não encontrado com o ID: " + emprestimoDTO.getLeitorId()));

        Emprestimo emprestimo = EmprestimoMapper.toEntity(emprestimoDTO);
        emprestimo.setLeitor(leitor);

        emprestimo = emprestimoRepository.save(emprestimo);
        return EmprestimoMapper.toDTO(emprestimo);
    }

    public void deletar(Long id) {
        if (!emprestimoRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível excluir. Empréstimo não encontrado com o ID: " + id);
        }
        emprestimoRepository.deleteById(id);
    }
}