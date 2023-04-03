package com.integrador.back.backintegrador.servicios;

import com.integrador.back.backintegrador.datos.DatosDummy;
import com.integrador.back.backintegrador.entity.Usuario;
import com.integrador.back.backintegrador.repositorio.UsuarioRepositorio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;

@SpringBootTest


class UsuarioServicioImplTest {

    @MockBean
    private UsuarioRepositorio repo;

    @Autowired
    private UsuarioServicioImpl implPrueba;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void crearUsuario() {
        Usuario usuario = DatosDummy.getUsuario();
        implPrueba.crearUsuario(usuario);

        ArgumentCaptor<Usuario> categoryArgumentCaptor = ArgumentCaptor.forClass(Usuario.class);
        verify(repo).save(categoryArgumentCaptor.capture());

        Usuario userCaptor = categoryArgumentCaptor.getValue();

        assertThat(userCaptor).isEqualTo(usuario);

        verify(repo).save(any());
    }

    @Test
    void obtenerUsuario() {
        String nombreUsuario = "Fer";
        when(repo.findByNombreUsuario(nombreUsuario)).thenReturn(Optional.of(DatosDummy.getUsuario()));
        Usuario usuario = implPrueba.obtenerUsuario(nombreUsuario);
        assertThat(usuario.getNombreUsuario()).isEqualTo("Fer");
    }

    @Test
    void obtenerUsuarioIncorrecto() {

        String nombreUsuario = "usuario_inexistente";
        given(this.repo.findByNombreUsuario(nombreUsuario)).willReturn(Optional.empty());

        assertThatThrownBy(() -> implPrueba.obtenerUsuario(nombreUsuario)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void actualizarUsuario() {

        Integer idUsuario = 1;
        Usuario usuarioAactualizar = (DatosDummy.getUsuario());

        given(repo.findById(idUsuario)).willReturn(Optional.of(DatosDummy.getUsuario()));
        given(implPrueba.actualizarUsuario(idUsuario,usuarioAactualizar)).willReturn(usuarioAactualizar);
        Usuario usuarioActualizado = implPrueba.actualizarUsuario(idUsuario, usuarioAactualizar);

        ArgumentCaptor<Usuario> categoryArgumentCaptor = ArgumentCaptor.forClass(Usuario.class);
        verify(repo).save(categoryArgumentCaptor.capture());

        assertThat(usuarioActualizado.getContrasenia()).isEqualTo("fer123");
        assertThat(usuarioActualizado.getNombreUsuario()).isEqualTo("Fer");
    }

    @Test
    void noPuedeActualizar() {

        Integer idUsuario = 1;
        Usuario usuarioAactualizar = DatosDummy.getUsuario();

        given(repo.findById(idUsuario)).willReturn(Optional.empty());

        assertThatThrownBy(() -> implPrueba.actualizarUsuario(idUsuario,usuarioAactualizar)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void eliminarUsuario() {
        Integer idUser = 1;

        given(repo.findById(idUser)).willReturn(Optional.of(DatosDummy.getUsuario()));
        willDoNothing().given(repo).deleteById(DatosDummy.getUsuario().getIdusuario());
        implPrueba.eliminarUsuario(idUser);

        verify(repo,times(1)).deleteById(any());
    }

    @Test
    void eliminarUsuarioInvalido(){
        Integer idUser = 1;

        given(repo.findById(idUser)).willReturn(Optional.empty());

        assertThatThrownBy(() -> implPrueba.eliminarUsuario(idUser)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void validarUsuario() {
        Usuario usuario = DatosDummy.getUsuario();

        given(repo.findByParaValidar(usuario.getEmail(), usuario.getContrasenia())).willReturn(Optional.of(usuario));
        boolean userTmp = implPrueba.validarUsuario(usuario);

        assertThat(userTmp).isTrue();
    }
}
