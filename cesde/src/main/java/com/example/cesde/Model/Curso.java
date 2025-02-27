package com.example.cesde.Model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Curso {
    @Id
    @SequenceGenerator(name = "curso_sequence", sequenceName = "curso_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_sequence")
    private Long id;
    private String nombre;
    private String descripcion;
    private Float precio;
    private LocalDateTime fechaInicio;

    @ManyToOne
    @JoinColumn(name = "docente_id", referencedColumnName = "id")
    private Docente docente;

    public Curso() {
    }

    public Curso(Long id, String nombre, String descripcion, Float precio, LocalDateTime fechaInicio, Docente docente) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.docente = docente;
    }

    public Curso(String nombre, String descripcion, Float precio, LocalDateTime fechaInicio, Docente docente) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.docente = docente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
