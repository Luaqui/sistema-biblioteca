package com.biblioteca.mapper;

import com.biblioteca.dto.EmprestimoDTO;
import com.biblioteca.entity.Emprestimo;
import com.biblioteca.entity.Leitor;

public class EmprestimoMapper {

    public static EmprestimoDTO toDTO(Emprestimo emprestimo) {
        if (emprestimo == null) {
            return null;
        }
        EmprestimoDTO dto = new EmprestimoDTO();
        dto.setId(emprestimo.getId());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataPrevistaDevolucao(emprestimo.getDataPrevistaDevolucao());
        dto.setStatus(emprestimo.getStatus());
        
        if (emprestimo.getLeitor() != null) {
            dto.setLeitorId(emprestimo.getLeitor().getId());
        }
        
        return dto;
    }

    public static Emprestimo toEntity(EmprestimoDTO dto) {
        if (dto == null) {
            return null;
        }
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setId(dto.getId());
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataPrevistaDevolucao(dto.getDataPrevistaDevolucao());
        emprestimo.setStatus(dto.getStatus());

       if (dto.getLeitorId() != null) {
            Leitor leitor = new Leitor();
            leitor.setId(dto.getLeitorId());
            emprestimo.setLeitor(leitor);
        }

        return emprestimo;
    }
}