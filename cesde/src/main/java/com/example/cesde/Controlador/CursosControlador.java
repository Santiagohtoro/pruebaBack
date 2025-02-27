package com.example.cesde.Controlador;

import com.example.cesde.Model.Curso;
import com.example.cesde.Service.CursosServicios;
import com.example.cesde.repository.ICursosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Cursos")

public class CursosControlador {
    @Autowired
    CursosServicios cursosServicios;

    @PostMapping(value ="/crear", consumes = {"application/json"})
    public ResponseEntity create(@RequestBody Curso curso){
        cursosServicios.create(curso);
        return new ResponseEntity("Se ha creado el curso: " + curso.getNombre(), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{nombre}")
    public ResponseEntity delete(@PathVariable String nombre){
        Curso curso = cursosServicios.buscarPorNombre(nombre);
        if(curso != null){
            cursosServicios.delete(nombre);
            return new ResponseEntity("Se ha eliminado el curso " + curso.getNombre() + " con éxito", HttpStatus.OK);
        } else {
            return new ResponseEntity("No se pudo eliminar porque no se encontró el curso : " + nombre, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity update(@RequestBody Curso curso){
        if(cursosServicios.buscarPorNombre(curso.getNombre()) == null){
            return new ResponseEntity("No se ha podido actualizar porque no se encontró el curso : " + curso.getNombre(), HttpStatus.BAD_REQUEST);
        } else {
            cursosServicios.update(curso);
            return new ResponseEntity("Se ha actualizado el curso " + curso.getNombre() + " con éxito", HttpStatus.OK);
        }
    }


    @GetMapping("/{nombre}")
    public ResponseEntity buscarPorNombre(@PathVariable String nombre){
        Curso cur = cursosServicios.buscarPorNombre(nombre);

        if(cur == null){
            return new ResponseEntity("No se encontró un curso con el nombre: " + nombre, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(cur, HttpStatus.OK);
        }
    }
    @GetMapping("/{precio}")
    public ResponseEntity buscarPorPrecio(@PathVariable Float precio){
        Curso cur = cursosServicios.buscarPorPecio(precio);

        if(cur == null){
            return new ResponseEntity("No se encontraron cursos a " + precio, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(cur, HttpStatus.OK);
        }
    }

    @PostMapping("/filter")
    public ResponseEntity buscarPorDocente(@RequestBody String nombre){
        List<Curso> cursos = cursosServicios.buscarPorDocente(nombre);

        if(cursos == null){
            return new ResponseEntity("No hay cursos asignados a este docente", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(cursos, HttpStatus.OK);
        }
    }
}
