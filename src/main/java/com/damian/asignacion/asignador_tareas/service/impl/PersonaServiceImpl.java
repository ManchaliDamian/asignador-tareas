package com.damian.asignacion.asignador_tareas.service.impl;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.persistencia.DAOs.PersonaDAO;
import com.damian.asignacion.asignador_tareas.persistencia.repositories.interfaces.PersonaRepository;
import com.damian.asignacion.asignador_tareas.service.interfaces.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaServiceImpl( PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    @Override
    public Persona crear(Persona persona) {
        return personaRepository.crear(persona);
    }

    @Override
    public Persona actualizar(Persona persona) {
        return personaRepository.actualizar(persona);
    }

    @Override
    public Optional<Persona> recuperar(Long personaId) {
        return this.personaRepository.recuperar(personaId);
    }

    @Override
    public void eliminar(Long personaId) {
        this.personaRepository.eliminar(personaId);
    }

    @Override
    public List<Persona> recuperarTodos() {
        return personaRepository.recuperarTodos();
    }
}
