package com.damian.asignacion.asignador_tareas.services;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.service.interfaces.DataService;
import com.damian.asignacion.asignador_tareas.service.interfaces.PersonaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PersonaServiceTest {

    @Autowired private DataService dataService;
    @Autowired private PersonaService personaService;
    private Persona damian;

    @BeforeEach
    void setUp() {
        damian = new Persona("Damian", "Manchali");
        damian = personaService.crear(damian);
    }
    @Test
    void crearPersona() {

        assertEquals("Damian", damian.getNombre());
    }
    @Test
    void recuperarPersona() {

        Optional<Persona> personaRecuperada = personaService.recuperar(damian.getId());

        assertEquals("Damian", personaRecuperada.get().getNombre());
        assertEquals(damian.getId(), personaRecuperada.get().getId());
    }

    @Test
    void eliminarPersona() {

        personaService.eliminar(damian.getId());
        Optional<Persona> personaEliminada = personaService.recuperar(damian.getId());
        assertTrue(personaEliminada.isEmpty());
    }

    @AfterEach
    void cleanUp() {
        dataService.eliminarTodo();
    }
}
