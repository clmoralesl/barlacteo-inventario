package com.bar_lacteo.inventario.Ubicacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ubicacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Ubicacion {

    @Id
    @Column(name = "id_ubicacion")
    private Long idUbicacion;

    @Column(name = "descripcion_ubicacion", length = 100, nullable = false)
    private String descripcionUbicacion;
    
}
