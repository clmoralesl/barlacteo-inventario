package com.bar_lacteo.inventario.Producto;


import com.bar_lacteo.inventario.Categoria.Categoria;

import jakarta.persistence.*;


@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @Column(name = "cod_barra")
    private Integer codigoBarra;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_unitario", nullable = false)
    private Integer precioUnitario;

    @Column(name = "stock_min", nullable = false)
    private Integer stockMinimo;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
    
        public Producto() {
    }

        public Producto(Integer codigoBarra, String nombreProducto, String descripcion, Integer precioUnitario,
                Integer stockMinimo, Categoria categoria) {
            this.codigoBarra = codigoBarra;
            this.nombreProducto = nombreProducto;
            this.descripcion = descripcion;
            this.precioUnitario = precioUnitario;
            this.stockMinimo = stockMinimo;
            this.categoria = categoria;
        }

        public Integer getCodigoBarra() {
            return codigoBarra;
        }

        public void setCodigoBarra(Integer codigoBarra) {
            this.codigoBarra = codigoBarra;
        }

        public String getNombreProducto() {
            return nombreProducto;
        }

        public void setNombreProducto(String nombreProducto) {
            this.nombreProducto = nombreProducto;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Integer getPrecioUnitario() {
            return precioUnitario;
        }

        public void setPrecioUnitario(Integer precioUnitario) {
            this.precioUnitario = precioUnitario;
        }

        public Integer getStockMinimo() {
            return stockMinimo;
        }

        public void setStockMinimo(Integer stockMinimo) {
            this.stockMinimo = stockMinimo;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }
    

    

}
