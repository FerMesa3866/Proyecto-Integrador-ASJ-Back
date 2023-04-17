package com.integrador.back.backintegrador.controller;


import com.integrador.back.backintegrador.entity.Usuario;
import com.integrador.back.backintegrador.exception.ErrorProcessException;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioDTO;
import com.integrador.back.backintegrador.negocio.DTO.UsuarioLoginDTO;
import com.integrador.back.backintegrador.negocio.mapper.UsuarioMapper;
import com.integrador.back.backintegrador.servicios.UsuarioServicio;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
/*import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Allowed actios for the User Entity", tags = "User Controller")

@CrossOrigin("http://localhost:4200")

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioServicio servicio;

    private final UsuarioMapper mapper;


    @PostMapping(path = "/")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws ErrorProcessException {
        servicio.crearUsuario(mapper.dtoAentidad(usuarioDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/{nombreUsuario}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable String nombreUsuario)
            throws ErrorProcessException {
        return ResponseEntity.ok(servicio.obtenerUsuario(nombreUsuario));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) throws ErrorProcessException{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.actualizarUsuario(id, usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id) throws ErrorProcessException{
        servicio.eliminarUsuario(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("El usuario se elimino correctamente");
    }

    @PostMapping("/login")
    public ResponseEntity<?> validarUsuario(@RequestBody UsuarioLoginDTO usuarioLoginDTO) throws ErrorProcessException{
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.validarUsuario(usuarioLoginDTO));
    }

}
