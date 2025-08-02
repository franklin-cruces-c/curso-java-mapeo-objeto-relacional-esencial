package com.linkedin.learning.otrareunionmas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import com.linkedin.learning.otrareunionmas.dominio.Acta;
import com.linkedin.learning.otrareunionmas.dominio.Persona;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;

public class ReunionDao extends AbstractDao<Reunion> {
	public ReunionDao() {
		setClazz(Reunion.class);
	}

	public Reunion proximaReunion() {
		String qlString = "FROM " + Reunion.class.getName() + " WHERE fecha > now() order by fecha";
		Query query = getEm().createQuery(qlString).setMaxResults(1);
		return (Reunion) query.getSingleResult();
	}

	public List<Reunion> reunionesManhana() {
		String qlString = "FROM " + Reunion.class.getName() + " WHERE fecha BETWEEN ?1 AND ?2";
		TypedQuery<Reunion> query = (TypedQuery<Reunion>) getEm().createQuery(qlString, Reunion.class);
		LocalDate manhana = LocalDate.now().plusDays(1);
		query.setParameter(1, manhana.atStartOfDay());
		query.setParameter(2, manhana.plusDays(1).atStartOfDay());
		return query.getResultList();
	}

	public List<Reunion> reunionesParticipante(String numeroEmpleado) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Reunion> criteriaQuery = cb.createQuery(Reunion.class);

		Root<Persona> fromPersona = criteriaQuery.from(Persona.class);
		criteriaQuery.where(cb.equal(fromPersona.get("numeroEmpleado"), numeroEmpleado));

		Join<Persona, Reunion> joinReunion = fromPersona.join("reuniones", JoinType.INNER);

		CriteriaQuery<Reunion> cq = criteriaQuery.multiselect(joinReunion);
		TypedQuery<Reunion> query = (TypedQuery<Reunion>) getEm().createQuery(cq);

		return query.getResultList();

	}
}
