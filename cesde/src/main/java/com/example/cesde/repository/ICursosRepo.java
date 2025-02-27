package com.example.cesde.repository;

import com.example.cesde.Model.Curso;
import com.example.cesde.Model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ICursosRepo extends JpaRepository<Curso, Long> {
    @Query(value = "SELECT * FROM curso WHERE nombre =?1 ", nativeQuery = true)
    Curso buscarPorNombre (String nombre);
    @Query(value = "SELECT * FROM curso WHERE precio =?1 ", nativeQuery = true)
    Curso buscarPorPrecio (Float precio);
    @Query(value = "SELECT * FROM curso WHERE curso.docente_id IN (SELECT docente.id FROM docente WHERE docente.nombre = ?1)", nativeQuery = true)
    List<Curso> filtrarPorDocente(String nombre);
}

