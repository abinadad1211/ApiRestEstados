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
import com.abinadad.web.app.model.Estado;
import com.abinadad.web.app.model.Municipio;
import com.abinadad.web.app.service.MunicipioService;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {
	@Autowired
	MunicipioService municipioService;
	
    @GetMapping("")
    public List<Municipio> list() {
        return municipioService.verMunicipios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipio> get(@PathVariable Integer id) {
        try {
        	Municipio municipio = municipioService.obtenerMunicipio(id);
            return new ResponseEntity<Municipio>(municipio, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Municipio>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/")
    public void add(@RequestBody Municipio municipio) {
    	municipioService.guardaMunicipio(municipio);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Municipio municipio, @PathVariable Integer id) {
        try {
        	Municipio municipioExiste = municipioService.obtenerMunicipio(id);
        	municipio.setId(id);            
            municipioService.guardaMunicipio(municipio);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	municipioService.eliminarCP(id);
    }
   
}
