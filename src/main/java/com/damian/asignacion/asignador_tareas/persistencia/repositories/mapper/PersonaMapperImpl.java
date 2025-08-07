package com.damian.asignacion.asignador_tareas.persistencia.repositories.mapper;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.persistencia.DTOs.PersonaJPADTO;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapperImpl implements PersonaMapper{
    @Override
    public Persona toDomain(PersonaJPADTO jpa) {
        Persona persona = new Persona(jpa.getNombre(), jpa.getApellido());
        persona.setId(jpa.getId());
        persona.setFueAsignado(jpa.isFueAsignado());
        return persona;
    }

    @Override
    public PersonaJPADTO toJpa(Persona persona) {
        PersonaJPADTO personaJPADTO = new PersonaJPADTO(persona.getNombre(), persona.getApellido());
        personaJPADTO.setId(persona.getId());
        personaJPADTO.setFueAsignado(persona.isFueAsignado());
        return personaJPADTO;
    }
}
