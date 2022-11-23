package com.abinadad.web.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abinadad.web.app.model.Estado;
import com.abinadad.web.app.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    EstadoService estadoService;

    @GetMapping("")
    public List<Estado> list() {
        return estadoService.verEstados();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Estado> get(@PathVariable Integer id) {
        try {
        	Estado estado = estadoService.obtenerEstado(id);
            return new ResponseEntity<Estado>(estado, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Estado>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/")
    public void add(@RequestBody Estado estado) {
    	estadoService.guardarEstado(estado);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Estado estado, @PathVariable Integer id) {
        try {
        	Estado estadoExiste = estadoService.obtenerEstado(id);
            estado.setId(id);            
            estadoService.guardarEstado(estado);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	estadoService.eliminar(id);
    }
   
}