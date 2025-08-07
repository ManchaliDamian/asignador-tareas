package com.damian.asignacion.asignador_tareas.service.impl;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.service.interfaces.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Override
    public Persona crear(Persona persona) {
        return null;
    }

    @Override
    public Persona actualizar(Persona persona) {
        return null;
    }

    @Override
    public Optional<Persona> recuperar(Long personaId) {
        return Optional.empty();
    }

    @Override
    public void eliminar(Long personaId) {

    }

    @Override
    public List<Persona> recuperarTodos() {
        return List.of();
    }
}
