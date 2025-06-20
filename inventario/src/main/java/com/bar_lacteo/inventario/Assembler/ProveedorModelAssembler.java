package com.bar_lacteo.inventario.Assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.bar_lacteo.inventario.Controlador.ProveedorControlador;
import com.bar_lacteo.inventario.Modelo.Proveedor;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ProveedorModelAssembler implements RepresentationModelAssembler<Proveedor, EntityModel<Proveedor>> {

    @Override
    @NonNull
    public EntityModel<Proveedor> toModel(@NonNull Proveedor proveedor) {
        return EntityModel.of(proveedor,
                linkTo(methodOn(ProveedorControlador.class).buscar(proveedor.getId())).withSelfRel(),
                linkTo(methodOn(ProveedorControlador.class).listar()).withRel("listar-proveedores"),
                linkTo(methodOn(ProveedorControlador.class).actualizar(proveedor.getId(), proveedor)).withRel("actualizar"),
                linkTo(methodOn(ProveedorControlador.class).buscarPorRut(proveedor.getRutProveedor())).withRel("buscar-por-rut")
        );
    }
}