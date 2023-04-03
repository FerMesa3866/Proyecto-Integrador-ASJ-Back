package com.integrador.back.backintegrador.repositorio;

import com.integrador.back.backintegrador.entity.Canciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface CancionesRepositorio extends JpaRepository <Canciones, Integer> {
}
