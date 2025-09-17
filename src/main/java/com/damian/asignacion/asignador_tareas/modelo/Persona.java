package com.damian.asignacion.asignador_tareas.modelo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private boolean fueAsignado;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
