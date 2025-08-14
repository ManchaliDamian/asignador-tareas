package com.damian.asignacion.asignador_tareas.persistencia.repositories.impl;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.persistencia.DAOs.PersonaDAO;
import com.damian.asignacion.asignador_tareas.persistencia.DTOs.PersonaJPADTO;
import com.damian.asignacion.asignador_tareas.persistencia.repositories.interfaces.PersonaRepository;
import com.damian.asignacion.asignador_tareas.persistencia.repositories.mapper.PersonaMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {
    private PersonaDAO personaDAO;
    private PersonaMapper personaMapper;

    public PersonaRepositoryImpl(PersonaDAO personaDAO, PersonaMapper personaMapper) {
        this.personaDAO = personaDAO;
        this.personaMapper = personaMapper;
    }

    @Override
    public Persona crear(Persona persona) {
        PersonaJPADTO personaJpa = personaMapper.toJpa(persona);
        personaJpa = personaDAO.save(personaJpa);
        return personaMapper.toDomain(personaJpa);
    }

    @Override
    public Optional<Persona> recuperar(Long personaId) {
        Optional<Persona> persona = personaDAO.findById(personaId).map(personaMapper::toDomain);
        return persona ;
    }

    @Override
    public void eliminar(Long personaId) {
        personaDAO.deleteById(personaId);
    }

    @Override
    public void eliminarTodo() {
        personaDAO.deleteAll();
    }
}
