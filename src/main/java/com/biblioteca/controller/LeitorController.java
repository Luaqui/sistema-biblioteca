package com.biblioteca.controller;

import com.biblioteca.dto.LeitorDTO;
import com.biblioteca.service.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leitores")
public class LeitorController {

    @Autowired
    private LeitorService leitorService;

    @GetMapping
    public ResponseEntity<List<LeitorDTO>> listarTodos() {
        List<LeitorDTO> leitores = leitorService.listarTodos();
        return ResponseEntity.ok(leitores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeitorDTO> buscarPorId(@PathVariable Long id) {
        LeitorDTO leitor = leitorService.buscarPorId(id);
        return ResponseEntity.ok(leitor);
    }

    @PostMapping
    public ResponseEntity<LeitorDTO> salvar(@RequestBody LeitorDTO leitorDTO) {
        LeitorDTO novoLeitor = leitorService.salvar(leitorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLeitor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        leitorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
