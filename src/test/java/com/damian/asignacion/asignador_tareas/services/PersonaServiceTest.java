package com.damian.asignacion.asignador_tareas.services;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.service.interfaces.PersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonaServiceTest {

    @Autowired private PersonaService personaService;
    private Persona damian;

    @BeforeEach
    void setUp() {
        damian = new Persona("Damian", "Manchali");

    }
    @Test
    void crearUsuario() {
        damian = personaService.crear(damian);
        assertEquals("Damian", damian.getNombre());
    }
}
