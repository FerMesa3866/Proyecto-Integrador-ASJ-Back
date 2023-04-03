package com.integrador.back.backintegrador.negocio.mapper;


import com.integrador.back.backintegrador.entity.Listas;
import com.integrador.back.backintegrador.negocio.DTO.ListasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface ListasMapper {


    ListasDTO entidadADto (Listas cancion);


    Listas dtoAentidad (ListasDTO usuario);
}
