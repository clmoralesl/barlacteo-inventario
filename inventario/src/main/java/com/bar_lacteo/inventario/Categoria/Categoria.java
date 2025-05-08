package com.bar_lacteo.inventario.Categoria;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre_categoria", unique = true, nullable = false)
    private String nombreCategoria;

    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    

}