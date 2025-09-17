package com.damian.asignacion.asignador_tareas.services;

import com.damian.asignacion.asignador_tareas.persistencia.repositories.interfaces.PersonaRepository;
import com.damian.asignacion.asignador_tareas.service.interfaces.DataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DataServiceImpl implements DataService {

    private final PersonaRepository personaRepository;

    public DataServiceImpl (PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void eliminarTodo() {
        personaRepository.eliminarTodo();
    }
}
