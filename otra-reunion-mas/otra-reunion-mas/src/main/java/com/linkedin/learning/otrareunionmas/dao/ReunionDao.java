package com.linkedin.learning.otrareunionmas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
}
