package com.damian.asignacion.asignador_tareas.persistencia.repositories.interfaces;

import com.damian.asignacion.asignador_tareas.modelo.Persona;

import java.util.Optional;

public interface PersonaRepository {
    Persona crear(Persona persona);

    Optional<Persona> recuperar(Long personaId);
}
