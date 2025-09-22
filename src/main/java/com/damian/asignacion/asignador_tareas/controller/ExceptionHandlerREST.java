package com.damian.asignacion.asignador_tareas.controller;

import com.damian.asignacion.asignador_tareas.controller.DTO.ErrorDTO;
import com.damian.asignacion.asignador_tareas.exception.PersonaNoEncontradaException;
import com.damian.asignacion.asignador_tareas.exception.PersonaYaAsignadaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerREST {

    @ExceptionHandler(PersonaNoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handlePersonaNoEncontrada(PersonaNoEncontradaException ex) {
        return new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(PersonaYaAsignadaException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDTO handlePersonaYaAsignada(PersonaYaAsignadaException ex) {
        return new ErrorDTO(ex.getMessage(), HttpStatus.CONFLICT.value());
    }

}
