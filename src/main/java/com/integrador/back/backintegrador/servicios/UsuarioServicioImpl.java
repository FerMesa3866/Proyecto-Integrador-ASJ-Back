package com.integrador.back.backintegrador.servicios;

import com.integrador.back.backintegrador.entity.Usuario;
import com.integrador.back.backintegrador.exception.ErrorProcessException;
import com.integrador.back.backintegrador.exception.NotFoundException;
import com.integrador.back.backintegrador.exception.UnautorizedException;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioDTO;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioLoginDTO;
import com.integrador.back.backintegrador.negocio.mapper.UsuarioMapper;
import com.integrador.back.backintegrador.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private final UsuarioRepositorio repo;

    private final UsuarioMapper mapper;

    @Override
    public void crearUsuario (Usuario usuario) throws ErrorProcessException{
       repo.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario (String nombreUsuario) throws ErrorProcessException{
        Usuario usuarioAobtener = repo
                .findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new NotFoundException("El usuario con el nombre: "+nombreUsuario+" no existe."));
        return usuarioAobtener;
    }

    @Override
    public Usuario actualizarUsuario (Integer id, UsuarioDTO usuarioDTO) throws ErrorProcessException {

        Usuario usuarioActualizar = repo
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario con el id: " + id + " no existe"));

        Usuario userTmp = mapper.dtoAentidad(usuarioDTO);
        try {
            usuarioActualizar.setNombreUsuario(userTmp.getNombreUsuario());
            usuarioActualizar.setEmail(userTmp.getEmail());
            usuarioActualizar.setContrasenia(userTmp.getContrasenia());

            return repo.save(usuarioActualizar);
        } catch (RuntimeException error){
            throw new ErrorProcessException(error.getMessage());
        }

    }

    @Override
    public void eliminarUsuario(Integer id) throws ErrorProcessException {
        repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario con el id " + id + " no existe"));
        try {
            repo.deleteById(id);
        } catch (RuntimeException error){
            throw new ErrorProcessException(error.getMessage());
        }
    }

    @Override
    public boolean validarUsuario(UsuarioLoginDTO usuarioLoginDTO) throws ErrorProcessException{
        System.out.println(usuarioLoginDTO.getNombre_usuario()+" "+usuarioLoginDTO.getContrasenia());

            Optional<Usuario> optional = repo.findByNombreUsuarioAndContrasenia(usuarioLoginDTO.getNombre_usuario(), usuarioLoginDTO.getContrasenia());
            if (optional.isPresent()){
                if (optional.get().getContrasenia().equals(usuarioLoginDTO.getContrasenia())){
                    return true;
                }
            }
            return false;

    }

}
