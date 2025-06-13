package com.bar_lacteo.inventario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table (name ="movimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Movimiento {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="id_movimiento")
    private Long idMovimiento;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column (name = "unidades",  nullable = false)
    private Long unidades;

    @Column (name = "motivo", length = 500)
    private String motivo;

    @ManyToOne
    @JoinColumn (name = "cod_barra",  nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn (name = "id_tipo_movimiento",  nullable = false)
    private TipoMovimiento tipoMovimiento;

    @ManyToOne
    @JoinColumn (name = "id_lote",  nullable = false)
    private Lote lote;

    @ManyToOne
    @JoinColumn (name = "id_ubicacion",  nullable = false)
    private Ubicacion ubicacion;

}
