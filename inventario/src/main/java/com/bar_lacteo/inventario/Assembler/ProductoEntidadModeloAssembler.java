package com.bar_lacteo.inventario.Assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;

import com.bar_lacteo.inventario.Controlador.ProductoControlador;
import com.bar_lacteo.inventario.Modelo.Producto;

@Component
public class ProductoEntidadModeloAssembler implements RepresentationModelAssembler<Producto, EntityModel<Producto>> {

    @Override
    @NonNull
    public EntityModel<Producto> toModel(@NonNull Producto producto) {
        return EntityModel.of(producto,
                linkTo(methodOn(ProductoControlador.class).obtenerProductoPorCodigo(producto.getCodigoBarra())).withSelfRel(),
                linkTo(methodOn(ProductoControlador.class).mostrarProductos()).withRel("Lista de productos"),
                linkTo(methodOn(ProductoControlador.class).modificarProducto(producto.getCodigoBarra(), producto)).withRel("Modificar"),
                linkTo(methodOn(ProductoControlador.class).eliminarProducto(producto.getCodigoBarra())).withRel("Eliminar")
        );
    }
}
