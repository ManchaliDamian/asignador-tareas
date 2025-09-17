package com.damian.asignacion.asignador_tareas.exception;

public class GrupoPersonasInvalidasException extends RuntimeException {
    public GrupoPersonasInvalidasException() {
        super(" Cantidad de personas a asignar inválida");
    }
}
