package com.integrador.back.backintegrador.controller;


import com.integrador.back.backintegrador.entity.Usuario;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioDTO;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioLoginDTO;
import com.integrador.back.backintegrador.negocio.mapper.UsuarioMapper;
import com.integrador.back.backintegrador.servicios.UsuarioServicio;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Allowed actios for the User Entity", tags = "User Controller")

@CrossOrigin("http://localhost:4200")

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioServicio servicio;

    private final UsuarioMapper mapper;


    public UsuarioController(UsuarioServicio servicio, UsuarioMapper mapper){
        this.servicio = servicio;
        this.mapper = mapper;
    }

    @PostMapping(path = "/crear")

    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        this.servicio.crearUsuario(mapper.dtoAentidad(usuarioDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/{nombreUsuario}")

    public ResponseEntity<?> obtenerUsuario(@PathVariable String nombreUsuario){
        try {
            Usuario usuario = servicio.obtenerUsuario(nombreUsuario);
            return ResponseEntity.ok().body(mapper.entidadADto(usuario));
        }
        catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no existe");
        }

    }

    @PutMapping(path = "/{id}")

    public ResponseEntity<?> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO){
        try {
            Usuario userTmp = mapper.dtoAentidad(usuarioDTO);

            Usuario updated = servicio.actualizarUsuario(id, userTmp);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.entidadADto(updated));
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) {
        try {
            servicio.eliminarUsuario(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> validarUsuario(@RequestBody UsuarioLoginDTO usuarioLoginDTO){
        try {
           boolean esValido = servicio.validarUsuario(mapper.usuarioLoginDTOAusuarioEntidad(usuarioLoginDTO));

           if(esValido){
               return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioLoginDTO);
           } else {
               throw new RuntimeException("Datos mal ingresados");
           }
        }
        catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }





//    @DeleteMapping("/delete/{nombreUsuario}")
//    public ResponseEntity<String> delete(@PathVariable String nombreUsuario) throws Exception {
//        serviceUsuario.deleteByUsuario(nombreUsuario);
//        return ResponseEntity.ok("Usuario con ID: " + nombreUsuario + " eliminado");
//    }



}
