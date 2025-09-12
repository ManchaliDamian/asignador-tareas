package com.damian.asignacion.asignador_tareas.persistencia.DTOs;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(
        name = "persona",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"nombre", "apellido"})
        }
)
public class PersonaJPADTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private boolean fueAsignado;

    public PersonaJPADTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fueAsignado = false;

    }
}
