package com.bar_lacteo.inventario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "estado_orden_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EstadoOrdenCompra {

    @Id
    @Column(name ="id_estado_orden")
    private Long idEstadoOrden;

    @Column (name ="descripcion_estado", length =  100, nullable = false)
    private String descripcionEstado;
    
}
