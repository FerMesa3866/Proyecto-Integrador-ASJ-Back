package com.integrador.back.backintegrador.servicios;

import com.integrador.back.backintegrador.entity.Usuario;


public interface UsuarioServicio {

    void crearUsuario (Usuario usuario);

    Usuario obtenerUsuario(String nombre_usuario);

    Usuario actualizarUsuario(Integer id, Usuario tmp);

    void eliminarUsuario(Integer id);

    boolean validarUsuario(Usuario usuario);
}
