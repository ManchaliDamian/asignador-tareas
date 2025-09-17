package com.damian.asignacion.asignador_tareas.persistencia.DAOs;

import com.damian.asignacion.asignador_tareas.persistencia.DTOs.PersonaJPADTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaDAO  extends JpaRepository<PersonaJPADTO, Long> {


    @Query(
            value = "SELECT * FROM persona WHERE fue_asignado = false ORDER BY RANDOM() LIMIT 2",
            nativeQuery = true
    )
    List<PersonaJPADTO> asignarDosPersonas();

    @Modifying
    @Transactional
    @Query("UPDATE PersonaJPADTO p SET p.fueAsignado = false")
    void resetAsignaciones();

}
