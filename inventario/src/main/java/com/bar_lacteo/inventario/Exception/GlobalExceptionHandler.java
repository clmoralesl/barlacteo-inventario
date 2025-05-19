package com.bar_lacteo.inventario.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex) {//
        Map<String, Object> body = new HashMap<>(); // Mapa guardar datos para respuesta
        body.put("mensajeError", ex.getMessage());
        body.put("codigoEstado", 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity <?> handleValidationExeptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler (Exception.class)
    public ResponseEntity<?>handleGeneralExeption(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "Error interno del servidor");
        body.put("detalle", ex.getMessage());
        body.put("codigo", 500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(AccesDeniedException.class)
    public ResponseEntity<?> handlerAccesDenied(AccesDeniedException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("mensajeError", ex.getMessage());
        body.put("codigoError", 403);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);

    }


    
}
