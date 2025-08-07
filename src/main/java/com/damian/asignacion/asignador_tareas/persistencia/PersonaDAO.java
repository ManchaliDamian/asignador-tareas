package com.damian.asignacion.asignador_tareas.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDAO  extends JpaRepository<PersonaJPADTO, Long> {
}
