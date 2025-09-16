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

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    void grupoParaAsignar() {
        List<Persona> personas = personaService.asignarGrupoTentativo();
        assertEquals(2, personas.size());
    }
    @Test
    void asignarSinCantidadValidaDePersonas() {
        damian.setFueAsignado(true);
        flavia.setFueAsignado(true);
        roberto.setFueAsignado(true);
        personaService.actualizar(damian);
        personaService.actualizar(flavia);
        personaService.actualizar(roberto);
        List<Persona> personas = personaService.asignarGrupoTentativo();
        assertEquals(2, personas.size());
    }
    @Test
    void resetearTodasLasAsignacionesTest() {
        damian.setFueAsignado(true);
        flavia.setFueAsignado(true);
        roberto.setFueAsignado(true);
        damian = personaService.actualizar(damian);
        flavia = personaService.actualizar(flavia);
        roberto = personaService.actualizar(roberto);
        personaService.resetearAsignaciones();

        Optional<Persona> dami = personaService.recuperar(damian.getId());
        Optional<Persona> fla = personaService.recuperar(flavia.getId());
        Optional<Persona> rob = personaService.recuperar(roberto.getId());

        assertFalse(dami.get().isFueAsignado());
        assertFalse(fla.get().isFueAsignado());
        assertFalse(rob.get().isFueAsignado());
    }
    @Test
    void asignarGrupoTest() {

        List<Persona> aAsignar = List.of(damian, flavia);
        aAsignar = personaService.asignarGrupo(aAsignar);
        assertEquals(2, aAsignar.size());
        assertTrue(aAsignar.get(0).isFueAsignado());
        assertTrue(aAsignar.get(1).isFueAsignado());
    }

    @AfterEach
    void cleanUp() {
        dataService.eliminarTodo();
    }
}
