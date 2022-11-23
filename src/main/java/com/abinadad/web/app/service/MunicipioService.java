package com.abinadad.web.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.abinadad.web.app.model.CodigoPostal;
import com.abinadad.web.app.model.Municipio;
import com.abinadad.web.app.repository.CodigoPostalRepository;
import com.abinadad.web.app.repository.MunicipioRepository;

@Service
@Transactional
public class MunicipioService {
	@Autowired
    private MunicipioRepository municipioRepository;
    
	public List<Municipio> verMunicipios() {
        return municipioRepository.findAll();
    }
     
    public void guardaMunicipio(Municipio municipio) {
    	municipioRepository.save(municipio);
    }

    public Municipio obtenerMunicipio(Integer id) {
        return municipioRepository.findById(id).get();
    }

    public void eliminarCP(Integer id) {
    	municipioRepository.deleteById(id);
    }

}
