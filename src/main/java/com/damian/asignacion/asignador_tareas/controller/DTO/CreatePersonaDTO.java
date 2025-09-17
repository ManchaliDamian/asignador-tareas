package com.damian.asignacion.asignador_tareas.controller.DTO;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import jakarta.validation.constraints.NotBlank;

public record CreatePersonaDTO(
        @NotBlank String nombre,
        @NotBlank String apellido
){
    public Persona aModelo() {
        return new Persona(this.nombre, this.apellido);
    }
}
