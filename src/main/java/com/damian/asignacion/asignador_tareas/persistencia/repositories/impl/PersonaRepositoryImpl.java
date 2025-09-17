package com.damian.asignacion.asignador_tareas.persistencia.repositories.impl;

import com.damian.asignacion.asignador_tareas.exception.GrupoPersonasInvalidasException;
import com.damian.asignacion.asignador_tareas.exception.PersonaNoEncontradaException;
import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.persistencia.DAOs.PersonaDAO;
import com.damian.asignacion.asignador_tareas.persistencia.DTOs.PersonaJPADTO;
import com.damian.asignacion.asignador_tareas.persistencia.repositories.interfaces.PersonaRepository;
import com.damian.asignacion.asignador_tareas.persistencia.repositories.mapper.PersonaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
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
        if (personaId == null) {
            throw new PersonaNoEncontradaException(personaId);
        }
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

    @Override
    public List<Persona> recuperarTodos() {
        List<PersonaJPADTO> listaRecuperada = personaDAO.findAll();
        return personaMapper.toDomainList(listaRecuperada);
    }

    @Override
    public Persona actualizar(Persona persona) {
        // Manejo de exceptions!!!

        if (persona.getId() == null) {
            throw new PersonaNoEncontradaException(persona.getId());
        }
        return personaMapper.toDomain(personaDAO.save(personaMapper.toJpa(persona)));
    }

    @Override
    public List<Persona> asignarGrupoDeDos() {
        List<Persona> personasAsignadas = personaMapper.toDomainList(personaDAO.asignarDosPersonas());
        return personasAsignadas;
    }

    @Override
    public void resetearAsignaciones() {
        personaDAO.resetAsignaciones();
    }

    @Override
    public List<Persona> asignarGrupo(List<Persona> personas) {
        // acá podría venir las personas con el seteo ya establecido del controller
        // la decisión por el momento es que se establezca en el back el seteo. luego veré si se puede hacer desde los datos enviados desde el front
        // testear si llega una lista inválida si es menor o mayor a 2
        // verificar que la lista no contenga personas que fueron asignadas
        // lanzar error en esos casos
        boolean algunoAsignado = personas.stream().anyMatch(Persona::isFueAsignado);
        if (personas.size() != 2 || algunoAsignado) {
            throw new GrupoPersonasInvalidasException();
        }

        List<Persona> personasAsignadas = personas.stream().map(
                p -> {
                    p.setFueAsignado(true);
                    return p;
                }).toList();
       personas = personasAsignadas.stream().map(e -> this.actualizar(e)).toList();
       return personas;
    }
}
