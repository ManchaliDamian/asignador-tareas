package com.damian.asignacion.asignador_tareas.persistencia.repositories.mapper;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.persistencia.DTOs.PersonaJPADTO;

public interface PersonaMapper {
    Persona toDomain(PersonaJPADTO jpa);
    PersonaJPADTO toJpa(Persona persona);
}
