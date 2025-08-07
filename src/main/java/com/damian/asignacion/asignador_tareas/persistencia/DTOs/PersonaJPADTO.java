package com.damian.asignacion.asignador_tareas.persistencia.DTOs;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EqualsAndHashCode
@Entity
@Table(name = "persona")
public class PersonaJPADTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String apellido;
    @Column(nullable = false)
    private boolean fueAsignado;

    public PersonaJPADTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;

    }
}
