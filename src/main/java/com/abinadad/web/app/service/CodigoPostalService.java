package com.abinadad.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abinadad.web.app.model.CodigoPostal;
import com.abinadad.web.app.model.Estado;
import com.abinadad.web.app.repository.CodigoPostalRepository;
import com.abinadad.web.app.repository.EstadoRepository;

import java.util.List;

import javax.transaction.Transactional;
@Service
@Transactional
public class CodigoPostalService {
    @Autowired
    private CodigoPostalRepository cpRepository;
    public List<CodigoPostal> verCPS() {
        return cpRepository.findAll();
    }
    
    public void guardarCP(CodigoPostal codigoPostal) {
    	cpRepository.save(codigoPostal);
    }

    public CodigoPostal obtenerCP(Integer id) {
        return cpRepository.findById(id).get();
    }

    public void eliminarCP(Integer id) {
    	cpRepository.deleteById(id);
    }
}