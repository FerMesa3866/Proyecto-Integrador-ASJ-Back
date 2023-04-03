package com.integrador.back.backintegrador.servicios;

import com.integrador.back.backintegrador.entity.Usuario;
import com.integrador.back.backintegrador.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private final UsuarioRepositorio repo;

    public UsuarioServicioImpl(UsuarioRepositorio repo){
        this.repo = repo;
    }

    @Override
    public void crearUsuario (Usuario usuario){
       repo.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario (String nombreUsuario){
        Optional<Usuario> optionalUsuario = repo.findByNombreUsuario(nombreUsuario);
        System.out.println(optionalUsuario);
        if (optionalUsuario.isPresent()){
            return optionalUsuario.get();
        } else {
            throw new RuntimeException("El usuario con el nombre: "+nombreUsuario+" no existe.");
        }

    }

    @Override
    public Usuario actualizarUsuario (Integer id, Usuario usuario){

        Usuario usuarioActualizar;

        Optional<Usuario> optionalUser = repo.findById(id);
        if (optionalUser.isPresent()) {
            usuarioActualizar = optionalUser.get();
        }
        else {
            throw new RuntimeException("Usuario con el id: " + id + " no existe");
        }

        usuarioActualizar.setNombreUsuario(usuario.getNombreUsuario());
        usuarioActualizar.setEmail(usuario.getEmail());
        usuarioActualizar.setContrasenia(usuario.getContrasenia());

        return repo.save(usuarioActualizar);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        Optional<Usuario> optionalUsuario = repo.findById(id);

        if (optionalUsuario.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Usuario con el id" + id + "no existe");
        }
    }

    @Override
    public boolean validarUsuario(Usuario usuario) {
            return repo.findByNombreUsuarioAndContrasenia(usuario.getNombreUsuario(), usuario.getContrasenia()).isPresent();
    }




}
