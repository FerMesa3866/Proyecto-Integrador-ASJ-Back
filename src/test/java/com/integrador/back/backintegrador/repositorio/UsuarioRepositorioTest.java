package com.integrador.back.backintegrador.repositorio;

import com.integrador.back.backintegrador.datos.DatosDummy;
import com.integrador.back.backintegrador.entity.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UsuarioRepositorioTest {

    @Autowired
    private UsuarioRepositorio repo;

    @BeforeEach
    void setUp() {
        repo.save(DatosDummy.getUsuario());
    }

    @AfterEach
    void tearDown() {
        repo.deleteAll();
    }

    @Test
    void findByParaValidar() {
        Optional<Usuario> usuarioOpcional = this.repo.findByParaValidar("Fer", "fer123");

        assertThat(usuarioOpcional.isPresent()).isTrue();
        assertThat(usuarioOpcional.get().getNombreUsuario()).isEqualTo("Fer");
        assertThat(usuarioOpcional.get().getContrasenia()).isEqualTo("fer123");
    }

    @Test
    void findByNombreUsuario() {

        Optional<Usuario> usuarioOpcional = this.repo.findByNombreUsuario("Fer");

        assertThat(usuarioOpcional.isPresent()).isTrue();
        assertThat(usuarioOpcional.get().getNombreUsuario()).isEqualTo("Fer");

    }
}
