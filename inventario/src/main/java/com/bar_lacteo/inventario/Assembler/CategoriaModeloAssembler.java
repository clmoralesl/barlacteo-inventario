package com.bar_lacteo.inventario.Assembler;

import com.bar_lacteo.inventario.Modelo.Categoria;

import com.bar_lacteo.inventario.Controlador.CategoriaControlador;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CategoriaModeloAssembler implements RepresentationModelAssembler<Categoria, EntityModel<Categoria>> {

    @Override
    @NonNull
    public EntityModel<Categoria> toModel(@NonNull Categoria categoria) {
        return EntityModel.of(categoria,
                linkTo(methodOn(CategoriaControlador.class).listarCategoria()).withRel("categorias"),
                linkTo(methodOn(CategoriaControlador.class).eliminarCategoria(categoria.getIdCategoria())).withRel("eliminar"),
                linkTo(methodOn(CategoriaControlador.class).actualizarCategoria(
                        categoria.getIdCategoria(), categoria.getNombreCategoria())).withRel("actualizar"),
                linkTo(methodOn(CategoriaControlador.class).obtenerCategoria(categoria.getIdCategoria())).withRel("self"));
    }
}