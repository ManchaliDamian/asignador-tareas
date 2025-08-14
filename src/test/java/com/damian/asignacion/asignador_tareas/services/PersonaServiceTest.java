package com.damian.asignacion.asignador_tareas.services;

import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.service.interfaces.DataService;
import com.damian.asignacion.asignador_tareas.service.interfaces.PersonaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PersonaServiceTest {

    @Autowired private DataService dataService;
    @Autowired private PersonaService personaService;
    private Persona damian;
    private Persona flavia;
    private Persona roberto;

    @BeforeEach
    void setUp() {
        damian = new Persona("Damian", "Manchali");
        roberto = new Persona("Roberto", "L");
        flavia = new Persona("Flavia", "G");
        damian = personaService.crear(damian);
        roberto= personaService.crear(roberto);
        flavia = personaService.crear(flavia);
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
    void actualiarNombreDePersona() {
       damian.setNombre("Franco");
       damian = personaService.actualizar(damian);

       assertEquals("Franco", damian.getNombre());
    }

    @Test
    void eliminarPersona() {

        personaService.eliminar(damian.getId());
        Optional<Persona> personaEliminada = personaService.recuperar(damian.getId());
        assertTrue(personaEliminada.isEmpty());
    }
    @Test
    void recuperarTodosPersonas() {
        List<Persona> lista = personaService.recuperarTodos();
        assertEquals(3, lista.size());
    }
    @AfterEach
    void cleanUp() {
        dataService.eliminarTodo();
    }
}
