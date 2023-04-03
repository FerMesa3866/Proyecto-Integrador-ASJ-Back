package com.integrador.back.backintegrador.repositorio;

import com.integrador.back.backintegrador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository


public interface UsuarioRepositorio extends JpaRepository <Usuario, Integer> {

    @Query("FROM Usuario u WHERE u.nombreUsuario = ?1 and u.contrasenia = ?2")
    Optional<Usuario> findByParaValidar(String nombre_usuario, String contrasenia);

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    Optional<Usuario> findByNombreUsuarioAndContrasenia(String nombre_usuario, String contrasenia);
}
