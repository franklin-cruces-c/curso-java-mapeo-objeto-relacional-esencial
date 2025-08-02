package com.linkedin.learning.otrareunionmas.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.linkedin.learning.otrareunionmas.dominio.Sala;

public class SalaDao extends AbstractDao<Sala> {

	public SalaDao() {
		setClazz(Sala.class);
	}

	public List<Sala> findSalasParaNSinCriteria(int n) {
		String qlString = " FROM " + Sala.class.getName() + " WHERE capacidad >= ?1";
		TypedQuery<Sala> query = (TypedQuery<Sala>) getEm().createQuery(qlString, Sala.class);

		query.setParameter(1, n);
		return query.getResultList();
	}

	public List<Sala> findSalasParaN(int n) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Sala> criteriaQuery = cb.createQuery(Sala.class);

		Root<Sala> root = criteriaQuery.from(Sala.class);
		criteriaQuery.select(root).where(cb.ge(root.get("capacidad"), n));
		TypedQuery<Sala> query = (TypedQuery<Sala>) getEm().createQuery(criteriaQuery);
		return query.getResultList();
	}
}
