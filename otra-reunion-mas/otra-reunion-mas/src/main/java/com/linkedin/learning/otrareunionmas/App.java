package com.linkedin.learning.otrareunionmas;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;

import com.linkedin.learning.otrareunionmas.dao.ReunionDao;
import com.linkedin.learning.otrareunionmas.dao.SalaDao;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;
import com.linkedin.learning.otrareunionmas.dominio.Sala;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Version de java: " + System.getProperty("java.version"));
		ReunionDao rdao = new ReunionDao();
		List<Reunion> lr = rdao.getAll();
		System.out.println(lr);

		Reunion r = new Reunion(LocalDateTime.now(), "Reunion de test");
		System.out.println(r);
		rdao.save(r);
		System.out.println(r);
		lr = rdao.getAll();
		System.out.println(lr);

		// Reunion r2 = new Reunion(LocalDateTime.now().plus(2,ChronoUnit.DAYS),
		// "Reunion de pasado mañana");
		Reunion r2 = new Reunion(LocalDateTime.now().plusDays(2), "Reunion de pasado mañana");
		rdao.save(r2);
		try {
			System.out.println("Tu proxima reunion es " + rdao.proximaReunion());
		} catch (NoResultException e) {
			System.out.println("No tienes ninguna reunion a la vista.");
		}

		Reunion r3 = new Reunion(LocalDateTime.now().plusDays(1), "Reunion de mañana");
		rdao.save(r3);
		List<Reunion> reunionesManhana = rdao.reunionesManhana();
		System.out.println("Para mañana:" + reunionesManhana);
		
		SalaDao salaDao = new SalaDao();
		
		Sala s = new Sala("S205","Sala grande",25);
		salaDao.save(s);
		System.out.println("Paso 1:"+salaDao.getAll());
		
		s.setDescripcion("Sala Grande reformada");
		salaDao.update(s);
		
		System.out.println("Paso 2:"+salaDao.getAll());
		
		Sala s2 = new Sala("99","Trastero",1);
		salaDao.save(s2);
		
		System.out.println("Paso 3:"+salaDao.getAll());
		
		salaDao.delete(s2);
		
		System.out.println("Paso 4:"+salaDao.getAll());
		
		

	}
}
