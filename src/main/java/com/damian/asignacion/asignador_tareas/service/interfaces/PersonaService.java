package com.damian.asignacion.asignador_tareas.service.interfaces;

import com.damian.asignacion.asignador_tareas.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Persona crear(Persona persona);
    Persona actualizar(Persona persona);
    Optional<Persona> recuperar(Long personaId);
    void eliminar(Long personaId);
    List<Persona> recuperarTodos();
    List<Persona> asignarGrupoTentativo();
    void resetearAsignaciones();
    List<Persona> asignarGrupo(List<Persona> personas);
}
