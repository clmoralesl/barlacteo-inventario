package com.bar_lacteo.inventario.Modelo;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @Column(name = "cod_barra")
    @Min(value = 1000, message = "El código de barra debe tener al menos 4 dígitos")
    @NotNull(message = "Debe ingresar un código de barras")
    private Integer codigoBarra;

    @NotBlank(message = "Debe ingresar un nombre de producto")
    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @NotNull(message = "Debe ingresar un precio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    @Column(name = "precio_unitario", nullable = false)
    private Integer precioUnitario;

    @NotNull(message = "Debe ingresar el stock")
    @Min(value = 1, message = "El stock mínimo debe ser mayor a 0")
    @Column(name = "stock_min", nullable = false)
    private Integer stockMinimo;

    @NotNull(message = "Debe ingresar un categoría")
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
}
