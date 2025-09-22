package com.damian.asignacion.asignador_tareas.exception;

public class PersonaYaAsignadaException extends RuntimeException {
    public PersonaYaAsignadaException() {
        super("Una o más personas ya fueron asignadas a un grupo");
    }
}
