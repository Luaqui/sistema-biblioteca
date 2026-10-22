package com.biblioteca.controller;

import com.biblioteca.dto.ExemplarDTO;
import com.biblioteca.service.ExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exemplares")
public class ExemplarController {

    @Autowired
    private ExemplarService exemplarService;

    @GetMapping
    public ResponseEntity<List<ExemplarDTO>> listarTodos() {
        List<ExemplarDTO> exemplares = exemplarService.listarTodos();
        return ResponseEntity.ok(exemplares);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExemplarDTO> buscarPorId(@PathVariable Long id) {
        ExemplarDTO exemplar = exemplarService.buscarPorId(id);
        return ResponseEntity.ok(exemplar);
    }

    @PostMapping
    public ResponseEntity<ExemplarDTO> salvar(@RequestBody ExemplarDTO exemplarDTO) {
        ExemplarDTO novoExemplar = exemplarService.salvar(exemplarDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoExemplar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        exemplarService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}