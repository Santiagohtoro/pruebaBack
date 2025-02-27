package com.example.cesde.Model;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "Docente")
public class Docente {
    @Id
    @SequenceGenerator(name = "docente_sequence", sequenceName = "docente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docente_sequence")
    private Long id;
    private String nombre;
    private String documento;
    private String correo;

    public Docente() {
    }

    public Docente(String nombre, String documento, String correo) {
        this.nombre = nombre;
        this.documento = documento;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}

