package com.bar_lacteo.inventario.Modelo;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    private String estado; // pendiente, recibido, cancelado
}