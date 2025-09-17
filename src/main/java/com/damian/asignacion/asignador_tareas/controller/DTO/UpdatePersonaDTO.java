package com.damian.asignacion.asignador_tareas.controller.DTO;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import jakarta.validation.constraints.NotBlank;

public record UpdatePersonaDTO(
        @NotBlank String nombre,
        @NotBlank String apellido
) {
    public void actualizarModelo(Persona persona) {
        persona.setNombre(this.nombre);
        persona.setApellido(this.apellido);
    }
}
