package com.linkedin.learning.otrareunionmas.dominio;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@ManyToOne(fetch = FetchType.LAZY)
	private Sala sala;

	@OneToOne(mappedBy = "reunion")
	private Acta acta;

	@ManyToMany(mappedBy = "reuniones", cascade = CascadeType.ALL)
	private Set<Persona> participantes;

	public Reunion() {
	}

	public Reunion(LocalDateTime fecha, String asunto) {
		this.fecha = fecha;
		this.asunto = asunto;
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

	/**
	 * @return the sala
	 */
	public Sala getSala() {
		return sala;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}

	/**
	 * @return the acta
	 */
	public Acta getActa() {
		return acta;
	}

	/**
	 * @param acta the acta to set
	 */
	public void setActa(Acta acta) {
		this.acta = acta;
	}

	/**
	 * @return the participantes
	 */
	public Set<Persona> getParticipantes() {
		return participantes;
	}

	/**
	 * @param participantes the participantes to set
	 */
	public void setParticipantes(Set<Persona> participantes) {
		this.participantes = participantes;
	}

	@Override
	public String toString() {
		return "Reunion {id=" + id + ", " + (fecha != null ? "fecha=" + fecha + ", " : "")
				+ (asunto != null ? "asunto=" + asunto + ", " : "") + (sala != null ? "sala=" + sala + ", " : "")
				// + (acta != null ? "acta=" + acta : "")
				+ "}";
	}

}
