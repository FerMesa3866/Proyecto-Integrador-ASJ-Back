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
@Table(name = "listas")

public class Listas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlistas")
    private Integer idlistas;

    @Column(name = "nombre_lista")
    private String nombre_lista;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "usuario_idusuario")
//    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn (name = "listas_idlistas"),
            inverseJoinColumns = @JoinColumn (name = "canciones_idcanciones")
    )
    private List<Canciones> canciones;
}
