package com.linkedin.learning.otrareunionmas.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala {

	@Id
	@Column(length = 20)
	private String id;

	private String descripcion;

	private int capacidad;

	@OneToMany(mappedBy = "sala")
	private List<Reunion> reuniones;
    
	public Sala() {
		
	}
	public Sala(String id, String descripcion, int capacidad) {
		this.id = id;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * @return the reuniones
	 */
	public List<Reunion> getReuniones() {
		return reuniones;
	}

	/**
	 * @param reuniones the reuniones to set
	 */
	public void setReuniones(List<Reunion> reuniones) {
		this.reuniones = reuniones;
	}

	@Override
	public String toString() {
		return "Sala {" + (id != null ? "id=" + id + ", " : "")
				+ (descripcion != null ? "descripcion=" + descripcion + ", " : "") + "capacidad=" + capacidad + "}";
	}

}
