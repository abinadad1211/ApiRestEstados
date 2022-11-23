package com.abinadad.web.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abinadad.web.app.model.Estado;
import com.abinadad.web.app.repository.EstadoRepository;

@Service
@Transactional
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    public List<Estado> verEstados() {
        return estadoRepository.findAll();
    }
    
    public void guardarEstado(Estado estado) {
    	estadoRepository.save(estado);
    }

    public Estado obtenerEstado(Integer id) {
        return estadoRepository.findById(id).get();
    }

    public void eliminar(Integer id) {
    	Estado estado = obtenerEstado(id);
    	estadoRepository.delete(estado);
    }
}
