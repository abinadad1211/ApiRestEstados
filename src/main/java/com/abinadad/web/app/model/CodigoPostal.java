package com.abinadad.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "codigo_postal")
public class CodigoPostal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcodigopostal")
	private int id; // Cambiar por long
	private String idmunicipio;
	
	@Column(name = "codigopostal")
	private String codigoPostal;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "idmunicipio", insertable = false, updatable = false)
	private Municipio municipio;
	
	public CodigoPostal() {

	}

	public CodigoPostal(int id, String idmunicipio, String codigoPostal, Municipio municipio) {
		this.id = id;
		this.idmunicipio = idmunicipio;
		this.codigoPostal = codigoPostal;
		this.municipio = municipio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdmunicipio() {
		return idmunicipio;
	}

	public void setIdmunicipio(String idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	
}
