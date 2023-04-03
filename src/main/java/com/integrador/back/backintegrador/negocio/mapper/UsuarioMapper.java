package com.integrador.back.backintegrador.negocio.mapper;

import com.integrador.back.backintegrador.entity.Usuario;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioDTO;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioLoginDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface UsuarioMapper {


    @Mappings({
            @Mapping(target = "id", source = "idusuario"),
            @Mapping(target = "nombre_usuario", source = "nombreUsuario")
    })
    UsuarioDTO entidadADto (Usuario usuario);


    @Mapping(target = "nombreUsuario", source = "nombre_usuario")
    Usuario dtoAentidad (UsuarioDTO usuarioDTO);

    @Mapping(target = "nombreUsuario", source = "nombre_usuario")
    Usuario usuarioLoginDTOAusuarioEntidad(UsuarioLoginDTO usuarioLoginDTO);
}
