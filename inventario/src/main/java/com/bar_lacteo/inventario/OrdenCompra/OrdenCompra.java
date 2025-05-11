package com.bar_lacteo.inventario.OrdenCompra;

import java.time.LocalDate;

import com.bar_lacteo.inventario.Producto.Producto;
import com.bar_lacteo.inventario.Proveedor.Proveedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha = LocalDate.now();

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Proveedor proveedor;

    private int cantidad;
    @Enumerated(EnumType.STRING)
    private EstadoOrdenCompra estado; // pendiente, recibido, cancelado
}