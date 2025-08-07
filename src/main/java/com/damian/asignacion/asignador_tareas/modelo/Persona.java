package com.damian.asignacion.asignador_tareas.modelo;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaUltimaAsignacion;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
