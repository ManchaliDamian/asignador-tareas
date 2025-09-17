package com.damian.asignacion.asignador_tareas.exception;

public class PersonaNoEncontradaException extends RuntimeException {
    public PersonaNoEncontradaException(Long id) {

      super("Persona no encontrada con id: " + id);
    }
}
