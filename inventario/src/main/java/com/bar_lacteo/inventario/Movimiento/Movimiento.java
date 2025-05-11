package com.bar_lacteo.inventario.Movimiento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;
import com.bar_lacteo.inventario.Producto.Producto;
import com.bar_lacteo.inventario.TipoMovimiento;

@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @Min(value = 1, message = "Unidades deben ser mayor a 0" )
    @NotNull(message = "Debe ingresar la cantidad de unidades")
    private Integer unidades;

    @NotBlank(message= "Debe ingresar el motivo")
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "Producto_cod_barra_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn (name = "id_tipo_movimiento",  nullable = false)
    private TipoMovimiento tipoMovimiento;

    
    @Column(name = "lote_id", nullable = false)
    private Long lote;

 
    @Column (name = "ubicacion_id", nullable = false)
    private String ubicacion;









    
}
