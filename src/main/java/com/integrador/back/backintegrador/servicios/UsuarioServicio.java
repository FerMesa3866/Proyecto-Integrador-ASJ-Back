package com.integrador.back.backintegrador.servicios;

import com.integrador.back.backintegrador.entity.Usuario;
import com.integrador.back.backintegrador.exception.ErrorProcessException;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioDTO;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioLoginDTO;


public interface UsuarioServicio {

    void crearUsuario (Usuario usuario) throws ErrorProcessException;

    Usuario obtenerUsuario(String nombre_usuario) throws ErrorProcessException;

    Usuario actualizarUsuario(Integer id, UsuarioDTO tmp) throws ErrorProcessException;

    void eliminarUsuario(Integer id) throws ErrorProcessException;

    boolean validarUsuario(UsuarioLoginDTO usuarioLoginDTO) throws ErrorProcessException;
}
