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

import com.abinadad.web.app.model.CodigoPostal;
import com.abinadad.web.app.service.CodigoPostalService;

@RestController
@RequestMapping("/codigoPostal")
public class CodigoPostalController {
    @Autowired
    CodigoPostalService codigoPostalService;

    @GetMapping("")
    public List<CodigoPostal> list() {
        return codigoPostalService.verCPS();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CodigoPostal> get(@PathVariable Integer id) {
        try {
        	CodigoPostal codigoPostal = codigoPostalService.obtenerCP(id);
            return new ResponseEntity<CodigoPostal>(codigoPostal, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CodigoPostal>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/")
    public void add(@RequestBody CodigoPostal codigoPostal) {
    	codigoPostalService.guardarCP(codigoPostal);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CodigoPostal codigoPostal, @PathVariable Integer id) {
        try {
        	CodigoPostal codigoPostalExiste = codigoPostalService.obtenerCP(id);
            codigoPostal.setId(id);            
            codigoPostalService.guardarCP(codigoPostalExiste);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	codigoPostalService.eliminarCP(id);
    }
}