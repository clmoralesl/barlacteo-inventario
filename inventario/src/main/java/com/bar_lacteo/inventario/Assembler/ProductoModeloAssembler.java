package com.bar_lacteo.inventario.Assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;

import com.bar_lacteo.inventario.Controlador.ProductoControlador;
import com.bar_lacteo.inventario.DTO.ProductoDTO;

@Component
public class ProductoModeloAssembler implements RepresentationModelAssembler<ProductoDTO, EntityModel<ProductoDTO>> {

    @Override
    @NonNull
    public EntityModel<ProductoDTO> toModel(@NonNull ProductoDTO producto) {

        return EntityModel.of(producto,
                // Link al recurso actual (detalle del producto)
                linkTo(methodOn(ProductoControlador.class).obtenerProductoPorCodigo(producto.getCodBarra())).withSelfRel(),

                // Link a la lista general
                linkTo(methodOn(ProductoControlador.class).listarProductos()).withRel("todos"),

                // Link a productos con stock bajo
                linkTo(methodOn(ProductoControlador.class).productoStockBajo()).withRel("bajo-stock")
        );
    }
}