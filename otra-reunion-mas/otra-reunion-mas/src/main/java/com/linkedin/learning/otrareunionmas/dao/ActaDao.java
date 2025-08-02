package com.linkedin.learning.otrareunionmas.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;

import com.linkedin.learning.otrareunionmas.dominio.Acta;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;

public class ActaDao extends AbstractDao<Acta> {
	public ActaDao() {
		setClazz(Acta.class);
	}

	public List<Acta> findActasReunionesAntiguas() {
		String qlQuery = " FROM " + Acta.class.getName() + " a WHERE a." 
	                              + Reunion.class.getSimpleName().toLowerCase() 
	                              + ".fecha < :ayer";

		TypedQuery<Acta> query = (TypedQuery<Acta>) getEm().createQuery(qlQuery, Acta.class);
		query.setParameter("ayer", LocalDateTime.now().minusDays(1));
		return query.getResultList();
	}
}
