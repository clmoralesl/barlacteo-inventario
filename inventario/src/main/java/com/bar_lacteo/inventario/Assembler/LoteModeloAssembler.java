package com.bar_lacteo.inventario.Assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;

import com.bar_lacteo.inventario.Modelo.Lote;
import com.bar_lacteo.inventario.Controlador.LoteControlador;

@Component
public class LoteModeloAssembler implements RepresentationModelAssembler<Lote, EntityModel<Lote>> {
    @Override
    @NonNull
    public EntityModel<Lote> toModel(@NonNull Lote lote) {
        return EntityModel.of(lote,
            linkTo(methodOn(LoteControlador.class).obtenerLotePorId(lote.getIdLote())).withSelfRel(),
            linkTo(methodOn(LoteControlador.class).listarLotes()).withRel("lotes"),
            linkTo(methodOn(LoteControlador.class).actualizarLote(lote.getIdLote(), lote)).withRel("modificar"),
            linkTo(methodOn(LoteControlador.class).eliminarLote(lote.getIdLote())).withRel("eliminar")
        );
    }
}