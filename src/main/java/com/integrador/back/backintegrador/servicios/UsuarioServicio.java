package com.integrador.back.backintegrador.servicios;

import com.integrador.back.backintegrador.entity.Usuario;
import com.integrador.back.backintegrador.exception.ErrorProcessException;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioLoginDTO;


public interface UsuarioServicio {

    void crearUsuario (Usuario usuario);

    Usuario obtenerUsuario(String nombre_usuario) throws ErrorProcessException;

    Usuario actualizarUsuario(Integer id, Usuario tmp);

    void eliminarUsuario(Integer id);

    boolean validarUsuario(UsuarioLoginDTO usuarioLoginDTO);
}
