package com.integrador.back.backintegrador.negocio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {

    private Integer id;

    private String nombre_usuario;

    private String contrasenia;

    private String email;


}
