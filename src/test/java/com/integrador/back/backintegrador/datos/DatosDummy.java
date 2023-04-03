package com.integrador.back.backintegrador.datos;

import com.integrador.back.backintegrador.entity.Listas;
import com.integrador.back.backintegrador.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatosDummy {

    public static Usuario getUsuario(){
        List<Listas> listasPrueba = new ArrayList<>();
        return new Usuario(1,"Fer","fer123","fer@email.com", listasPrueba);
//        return new Usuario();
    }

}
