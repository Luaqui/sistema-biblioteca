package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.entity.Exemplar;

public interface ExemplarRepository extends JpaRepository <Exemplar, Long> {
    
}
