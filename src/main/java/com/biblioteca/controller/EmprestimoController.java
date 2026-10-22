package com.biblioteca.controller;

import com.biblioteca.dto.EmprestimoDTO;
import com.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<EmprestimoDTO>> listarTodos() {
        List<EmprestimoDTO> emprestimos = emprestimoService.listarTodos();
        return ResponseEntity.ok(emprestimos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTO> buscarPorId(@PathVariable Long id) {
        EmprestimoDTO emprestimo = emprestimoService.buscarPorId(id);
        return ResponseEntity.ok(emprestimo);
    }

    @PostMapping
    public ResponseEntity<EmprestimoDTO> salvar(@RequestBody EmprestimoDTO emprestimoDTO) {
        EmprestimoDTO novoEmprestimo = emprestimoService.salvar(emprestimoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEmprestimo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
