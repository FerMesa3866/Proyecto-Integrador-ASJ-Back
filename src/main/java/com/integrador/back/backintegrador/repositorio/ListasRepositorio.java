package com.integrador.back.backintegrador.repositorio;

import com.integrador.back.backintegrador.entity.Listas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ListasRepositorio extends JpaRepository <Listas, Integer> {
}
