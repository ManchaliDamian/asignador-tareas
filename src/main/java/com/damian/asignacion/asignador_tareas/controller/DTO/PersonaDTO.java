package com.damian.asignacion.asignador_tareas.controller.DTO;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;


public record PersonaDTO(
        @Nonnull Long id,
        @NotBlank String nombre,
        @NotBlank String apellido,
        @Nonnull boolean fueAsignado
        ) {

    public static PersonaDTO desdeModelo(Persona persona) {
        return new PersonaDTO(
                persona.getId(),
                persona.getNombre(),
                persona.getApellido(),
                persona.isFueAsignado()
        );
    }
    public Persona aModelo() {
        return new Persona(this.nombre,  this.apellido);
    }

}
