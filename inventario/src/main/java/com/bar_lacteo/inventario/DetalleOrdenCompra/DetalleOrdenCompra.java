package com.bar_lacteo.inventario.DetalleOrdenCompra;

import com.bar_lacteo.inventario.OrdenCompra.OrdenCompra;
import com.bar_lacteo.inventario.Producto.Producto;

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
@Table(name = "detalle_orden_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DetalleOrdenCompra {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name ="id_detalle")
    private Long idDetalle;

    @ManyToOne
    @JoinColumn (name = "cod_barra", nullable = false)
    private Producto Producto;

    @ManyToOne
    @JoinColumn (name ="id_orden_compra", nullable = false)
    private OrdenCompra ordenCompra;

    @Column(name ="unidades", nullable =  false)
    private long unidades;

    @Column(name ="precio_unitario", nullable = false)
    private long precioUnitario;






    
    
}
