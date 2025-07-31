package com.linkedin.learning.otrareunionmas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OtraReunionMas");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
	public static void main(String args[]) {
		EntityManager mg = EntityManagerUtil.getEntityManager();
		System.out.println(""+mg.getClass().getCanonicalName());
	}
}
