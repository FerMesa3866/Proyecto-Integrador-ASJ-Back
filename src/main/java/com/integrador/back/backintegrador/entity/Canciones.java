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
@Table(name = "canciones")

public class Canciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcanciones")
    private Integer idcanciones;

    @Column(name = "nombre_cancion")
    private String cancion;

    @Column(name = "genero")
    private String genero;

    @Column(name = "artista")
    private String artista;

    @ManyToMany(mappedBy = "canciones")
    private List<Listas> listas;

}
