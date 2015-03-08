package com.sqma.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the funcion_metrica database table.
 * 
 */
@Entity
@Table(name = "funcion_metrica")
public class FuncionMetrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_FUNCION_METRICA_GENERATOR", sequenceName = "SEQ_FUNCION_METRICA", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCION_METRICA_GENERATOR")
	@Column(name = "id_funcion_metrica")
	private long idFuncionMetrica;

	private String descripcion;

	private String funcion;

	private String lenguaje;

	private String nombre;

	public FuncionMetrica() {
	}

	public long getIdFuncionMetrica() {
		return this.idFuncionMetrica;
	}

	public void setIdFuncionMetrica(long idFuncionMetrica) {
		this.idFuncionMetrica = idFuncionMetrica;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getLenguaje() {
		return this.lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idFuncionMetrica ^ (idFuncionMetrica >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionMetrica other = (FuncionMetrica) obj;
		if (idFuncionMetrica != other.idFuncionMetrica)
			return false;
		return true;
	}
	
	

}