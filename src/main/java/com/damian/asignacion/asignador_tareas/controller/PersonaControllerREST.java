package com.damian.asignacion.asignador_tareas.controller;


import com.damian.asignacion.asignador_tareas.controller.DTO.CreatePersonaDTO;
import com.damian.asignacion.asignador_tareas.controller.DTO.PersonaDTO;
import com.damian.asignacion.asignador_tareas.controller.DTO.UpdatePersonaDTO;
import com.damian.asignacion.asignador_tareas.exception.PersonaNoEncontradaException;
import com.damian.asignacion.asignador_tareas.modelo.Persona;
import com.damian.asignacion.asignador_tareas.service.interfaces.PersonaService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona")
public final class PersonaControllerREST {
    private final PersonaService personaService;

    public PersonaControllerREST (PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping
    public List<PersonaDTO> getPersonas(){
        List<Persona>  personas = personaService.recuperarTodos();
        return personas.stream().map(PersonaDTO::desdeModelo).toList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getPersona(@PathVariable Long id) {
        Persona persona = personaService.recuperar(id).orElseThrow(() -> new PersonaNoEncontradaException(id));
        return ResponseEntity.ok(PersonaDTO.desdeModelo(persona));
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> crear(@Valid @RequestBody CreatePersonaDTO dto) {
        Persona persona = dto.aModelo();
        Persona creada = personaService.crear(persona);

        URI location = URI.create("/persona/" + creada.getId());
        PersonaDTO respuesta = PersonaDTO.desdeModelo(creada);
        return ResponseEntity.created(location).body(respuesta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> actualizarPersona(@PathVariable Long id, @Valid @RequestBody UpdatePersonaDTO dto) {
        Persona persona = personaService.recuperar(id).orElseThrow(() -> new PersonaNoEncontradaException(id));
        dto.actualizarModelo(persona);
        Persona guardada = personaService.actualizar(persona);
        return ResponseEntity.ok(PersonaDTO.desdeModelo(persona));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaDTO> eliminarPersona(@PathVariable Long id) {
        personaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/reset")
    public List<PersonaDTO> resetearAsignados() {
        personaService.resetearAsignaciones();
        List<Persona> personasReseteadas = personaService.recuperarTodos();
        return personasReseteadas.stream().map(PersonaDTO::desdeModelo).toList();
    }
    @GetMapping("/grupo")
    public ResponseEntity<List<PersonaDTO>> grupoTentativo() {
        List<Persona> grupoT = personaService.asignarGrupoTentativo();
        List<PersonaDTO> grupo = grupoT.stream().map(PersonaDTO::desdeModelo).toList();
        return ResponseEntity.ok(grupo);
    }
    @PostMapping("/{id1}/asignar/{id2}")
    public ResponseEntity<List<PersonaDTO>> asignarGrupo(@PathVariable Long id1, @PathVariable Long id2) {
        List<Persona> personasAsignadas = personaService.asignarGrupo(id1, id2);
        return ResponseEntity.ok(personasAsignadas.stream().map(persona -> PersonaDTO.desdeModelo(persona)).toList());
    }
}
