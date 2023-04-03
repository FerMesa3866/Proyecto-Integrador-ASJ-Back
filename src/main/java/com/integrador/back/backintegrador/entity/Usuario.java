package com.integrador.back.backintegrador.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="usuario", uniqueConstraints = {@UniqueConstraint(columnNames = "nombre_usuario")})

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idusuario;

    @Column(name = "nombre_usuario", unique = true)
    private String nombreUsuario;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Listas> listas;




}
