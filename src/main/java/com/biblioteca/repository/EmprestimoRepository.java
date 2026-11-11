package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository <Emprestimo, Long> {
    
}
