package com.bar_lacteo.inventario.Producto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {

    boolean existsByCodigoBarra(Integer codigoBarra);
    Optional<Producto>findByCodigoBarra(Integer codigoBarra);

@Query(value = """
    SELECT 
        p.cod_barra, 
        p.nombre_producto, 
        p.precio_unitario AS precio,
        SUM(l.stock_lote) AS stock_actual, 
        p.stock_min, 
        c.nombre_categoria AS categoria
    FROM producto p 
    JOIN lote l ON p.cod_barra = l.cod_barra 
    JOIN categoria c ON p.id_categoria = c.id_categoria 
    GROUP BY p.cod_barra, p.nombre_producto, p.precio_unitario, p.stock_min, c.nombre_categoria 
    ORDER BY p.cod_barra
    """, nativeQuery = true)
    List<Object[]> listarProductos();
}
