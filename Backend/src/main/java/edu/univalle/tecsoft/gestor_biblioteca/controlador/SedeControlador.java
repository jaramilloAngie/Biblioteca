package edu.univalle.tecsoft.gestor_biblioteca.controlador;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Sede;
import edu.univalle.tecsoft.gestor_biblioteca.repositorio.SedeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sedes")
public class SedeControlador {
    private final SedeRepositorio sedeRepositorio;

    @Autowired
    public SedeControlador(SedeRepositorio sedeRepositorio) {
        this.sedeRepositorio = sedeRepositorio;
    }

    @GetMapping
    public ResponseEntity<List<Sede>> getAllSedes() {
        List<Sede> sedes = sedeRepositorio.findAll();
        return ResponseEntity.ok(sedes);
    }
}
