package com.example.cesde.Service;


import com.example.cesde.Model.Curso;
import com.example.cesde.repository.ICursosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosServicios {
    @Autowired
    private ICursosRepo cursosRepo;

    public Curso buscarPorNombre(String nombre){
        Optional<Curso> curso = Optional.ofNullable(cursosRepo.buscarPorNombre(nombre));
        return curso.orElse(null);
    }

    public Curso buscarPorPecio(Float precio){
        Optional<Curso> curso = Optional.ofNullable(cursosRepo.buscarPorPrecio(precio));
        return curso.orElse(null);
    }

    public List<Curso> buscarPorDocente(String nombre){
        if(cursosRepo.filtrarPorDocente(nombre)!= null){
            return cursosRepo.filtrarPorDocente(nombre);
        }else{
            return null;
        }

    }

    public Curso create(Curso curso){
        if(buscarPorNombre(curso.getNombre()) != null){
            return buscarPorNombre(curso.getNombre());
        } else {
            return cursosRepo.save(curso);
        }
    }

    public void delete(String nombre){
        Curso curso = cursosRepo.buscarPorNombre(nombre);
        cursosRepo.delete(curso);
    }

    public Curso update(Curso curso){
        Curso cur;
        if(cursosRepo.existsById(curso.getId())){
            cur = cursosRepo.save(curso);
        } else {
            cur = null;
        }
        return cur;
    }


}
