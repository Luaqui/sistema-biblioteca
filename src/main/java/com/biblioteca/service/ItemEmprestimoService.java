package com.biblioteca.service;

import com.biblioteca.dto.ItemEmprestimoDTO;
import com.biblioteca.entity.Emprestimo;
import com.biblioteca.entity.Exemplar;
import com.biblioteca.entity.ItemEmprestimo;
import com.biblioteca.mapper.ItemEmprestimoMapper;
import com.biblioteca.repository.EmprestimoRepository;
import com.biblioteca.repository.ExemplarRepository;
import com.biblioteca.repository.ItemEmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemEmprestimoService {

    @Autowired
    private ItemEmprestimoRepository itemEmprestimoRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ExemplarRepository exemplarRepository;

    public List<ItemEmprestimoDTO> listarTodos() {
        List<ItemEmprestimo> itens = itemEmprestimoRepository.findAll();
        return itens.stream()
                .map(ItemEmprestimoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ItemEmprestimoDTO buscarPorId(Long id) {
        Optional<ItemEmprestimo> itemOpt = itemEmprestimoRepository.findById(id);
        ItemEmprestimo item = itemOpt.orElseThrow(() -> new RuntimeException("Item de empréstimo não encontrado com o ID: " + id));
        return ItemEmprestimoMapper.toDTO(item);
    }

    public ItemEmprestimoDTO salvar(ItemEmprestimoDTO dto) {
        Emprestimo emprestimo = emprestimoRepository.findById(dto.getEmprestimoId())
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com o ID: " + dto.getEmprestimoId()));

        Exemplar exemplar = exemplarRepository.findById(dto.getExemplarId())
                .orElseThrow(() -> new RuntimeException("Exemplar não encontrado com o ID: " + dto.getExemplarId()));

        ItemEmprestimo item = ItemEmprestimoMapper.toEntity(dto);
        item.setEmprestimo(emprestimo);
        item.setExemplar(exemplar);

        item = itemEmprestimoRepository.save(item);
        return ItemEmprestimoMapper.toDTO(item);
    }

    public void deletar(Long id) {
        if (!itemEmprestimoRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível excluir. Item de empréstimo não encontrado com o ID: " + id);
        }
        itemEmprestimoRepository.deleteById(id);
    }
}