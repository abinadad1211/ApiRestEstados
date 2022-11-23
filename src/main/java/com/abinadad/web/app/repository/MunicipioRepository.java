package com.abinadad.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abinadad.web.app.model.Estado;
import com.abinadad.web.app.model.Municipio;

@Repository
public interface MunicipioRepository extends  JpaRepository<Municipio, Integer>,  JpaSpecificationExecutor<Municipio>{

} 