package com.biblioteca.controller;

import com.biblioteca.dto.ItemEmprestimoDTO;
import com.biblioteca.service.ItemEmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-emprestimo")
public class ItemEmprestimoController {

    @Autowired
    private ItemEmprestimoService itemEmprestimoService;

    @GetMapping
    public ResponseEntity<List<ItemEmprestimoDTO>> listarTodos() {
        List<ItemEmprestimoDTO> itens = itemEmprestimoService.listarTodos();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemEmprestimoDTO> buscarPorId(@PathVariable Long id) {
        ItemEmprestimoDTO item = itemEmprestimoService.buscarPorId(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<ItemEmprestimoDTO> salvar(@RequestBody ItemEmprestimoDTO dto) {
        ItemEmprestimoDTO novoItem = itemEmprestimoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemEmprestimoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
