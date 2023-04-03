package com.integrador.back.backintegrador.negocio.mapper;


import com.integrador.back.backintegrador.entity.Canciones;
import com.integrador.back.backintegrador.negocio.DTO.CancionesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface CancionesMapper {



    CancionesDTO entidadADto (Canciones cancion);


    Canciones dtoAentidad (CancionesDTO usuario);



}
