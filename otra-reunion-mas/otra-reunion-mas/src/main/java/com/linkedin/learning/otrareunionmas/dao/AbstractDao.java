/**
 * 
 */
package com.linkedin.learning.otrareunionmas.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.linkedin.learning.otrareunionmas.util.EntityManagerUtil;

/**
 * @param <T>
 * 
 */
public abstract class AbstractDao<T> implements Dao<T> {

	private EntityManager em = EntityManagerUtil.getEntityManager();

	private Class<T> clazz;

	@Override
	public Optional<T> get(long id) {
		return Optional.ofNullable(em.find(clazz, id));
	}

	@Override
	public List<T> getAll() {
		String qlString = "FROM " + clazz.getName();
		Query query = em.createQuery(qlString);
		return query.getResultList();
	}

	@Override
	public void save(T t) {
		executeInsideTransction(em -> em.persist(t));
	}

	@Override
	public void update(T t) {
		executeInsideTransction(em -> em.merge(t));
	}

	@Override
	public void delete(T t) {
		executeInsideTransction(em -> em.remove(t));
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	private void executeInsideTransction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();
		try {

			tx.begin();
			action.accept(em);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}

	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

}
