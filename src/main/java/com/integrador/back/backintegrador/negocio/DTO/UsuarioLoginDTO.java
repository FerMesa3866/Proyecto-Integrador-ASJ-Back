package com.integrador.back.backintegrador.negocio.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioLoginDTO {

    String nombre_usuario;
    String contrasenia;

}
