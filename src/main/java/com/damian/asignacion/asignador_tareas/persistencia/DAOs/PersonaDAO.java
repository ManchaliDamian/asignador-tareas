package com.damian.asignacion.asignador_tareas.persistencia.DAOs;

import com.damian.asignacion.asignador_tareas.persistencia.DTOs.PersonaJPADTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDAO  extends JpaRepository<PersonaJPADTO, Long> {
}
