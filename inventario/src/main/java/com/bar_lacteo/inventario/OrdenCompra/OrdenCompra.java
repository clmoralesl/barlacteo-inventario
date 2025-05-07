package com.bar_lacteo.inventario.OrdenCompra;

import java.time.LocalDate;

import com.bar_lacteo.inventario.Producto.Producto;
import com.bar_lacteo.inventario.Proveedor.Proveedor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
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

    private String estado; // pendiente, recibido, cancelado
}