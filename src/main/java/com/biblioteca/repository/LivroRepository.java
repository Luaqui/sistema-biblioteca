package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
