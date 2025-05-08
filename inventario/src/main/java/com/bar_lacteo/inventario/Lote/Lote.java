package com.bar_lacteo.inventario.Lote;

import java.sql.Date;

import com.bar_lacteo.inventario.OrdenCompra.OrdenCompra;
import com.bar_lacteo.inventario.Producto.Producto;
import com.bar_lacteo.inventario.Proveedor.Proveedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Lote")

public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Integer idLote;

    @ManyToOne
    @JoinColumn(name = "cod_barra", nullable = false)
    private Producto producto; 

    @Column(name = "numero_lote")
    private Integer numeroLote;

    @Column(name = "stock_lote")
    private Integer stockLote;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "rut_proveedor")
    private Proveedor proveedor;

<<<<<<< HEAD

    public Lote(){

    }


    public Lote(Integer idLote, Producto producto, Integer numeroLote, Integer stockLote, Date fechaVencimiento,
            OrdenCompra ordenCompra, Proveedor proveedor) {
        this.idLote = idLote;
        this.producto = producto;
        this.numeroLote = numeroLote;
        this.stockLote = stockLote;
        this.fechaVencimiento = fechaVencimiento;
        this.ordenCompra = ordenCompra;
        this.proveedor = proveedor;
    }


    public Integer getIdLote() {
        return idLote;
    }


    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }


    public Producto getProducto() {
        return producto;
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public Integer getNumeroLote() {
        return numeroLote;
    }


    public void setNumeroLote(Integer numeroLote) {
        this.numeroLote = numeroLote;
    }


    public Integer getStockLote() {
        return stockLote;
    }


    public void setStockLote(Integer stockLote) {
        this.stockLote = stockLote;
    }


    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }


    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }


    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }


    public Proveedor getProveedor() {
        return proveedor;
    }


    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    




=======
>>>>>>> origin/main
}
