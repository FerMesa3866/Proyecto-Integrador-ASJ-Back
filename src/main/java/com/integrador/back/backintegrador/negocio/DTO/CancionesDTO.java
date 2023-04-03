package com.integrador.back.backintegrador.negocio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CancionesDTO {

    private String cancion;

    private String genero;

    private String artista;
}
