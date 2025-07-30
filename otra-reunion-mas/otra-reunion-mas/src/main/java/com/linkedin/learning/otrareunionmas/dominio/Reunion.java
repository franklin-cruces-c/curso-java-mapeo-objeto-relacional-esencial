package com.linkedin.learning.otrareunionmas.dominio;

import java.time.LocalDateTime;
import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reunion")
public class Reunion {
	/**
	 * Cuando los atributos de la clase se llaman igual que los campos de la tabla
	 * se pueden omitir los @Column por ese motivo se comentan en este archivo
	 */

	// @Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @Column(name = "fecha")
	private LocalDateTime fecha;

	// @Column(name = "asunto")
	private String asunto;

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
	 * @return the fecha
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Reunion() {
	}

	public Reunion(LocalDateTime fecha, String asunto) {
		this.fecha = fecha;
		this.asunto = asunto;
	}


	@Override
	public String toString() {
		return "Reunion {id=" + id + ", " + (fecha != null ? "fecha=" + fecha + ", " : "")
				+ (asunto != null ? "asunto=" + asunto : "") + "}\n";
	}

}
