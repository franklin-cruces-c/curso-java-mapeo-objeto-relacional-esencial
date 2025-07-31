package com.linkedin.learning.otrareunionmas.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String numeroEmpleado;

	private String nombre;
	private String apellidos;

	@ManyToMany
	private Set<Reunion> reuniones;

	public Persona() {
		this.reuniones = new HashSet<Reunion>();
	}

	public Persona(String numeroEmpleado, String nombre, String apellidos) {
		this();
		this.numeroEmpleado = numeroEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the numeroEmpleado
	 */
	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	/**
	 * @param numeroEmpleado the numeroEmpleado to set
	 */
	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the reuniones
	 */
	public Set<Reunion> getReuniones() {
		return reuniones;
	}

	/**
	 * @param reuniones the reuniones to set
	 */
//	public void setReuniones(Set<Reunion> reuniones) {
//		this.reuniones = reuniones;
//	}
	public void addReunion(Reunion reunion) {
		reuniones.add(reunion);
		if (!reunion.getParticipantes().contains(this)) {
			reunion.addParticipante(this);
		}
	}

	@Override
	public String toString() {
		return "Persona {id=" + id + ", " + (numeroEmpleado != null ? "numeroEmpleado=" + numeroEmpleado + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellidos != null ? "apellidos=" + apellidos : "") + "}";
	}

}
