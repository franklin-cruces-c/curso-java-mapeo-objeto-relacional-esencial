package com.linkedin.learning.otrareunionmas;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import com.linkedin.learning.otrareunionmas.dao.ActaDao;
import com.linkedin.learning.otrareunionmas.dao.ReunionDao;
import com.linkedin.learning.otrareunionmas.dao.SalaDao;
import com.linkedin.learning.otrareunionmas.dominio.Acta;
import com.linkedin.learning.otrareunionmas.dominio.Persona;
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

		Persona marta = new Persona("E001", "Marta", "García López");
		Persona pedro = new Persona("E002", "Pedro", "Gómez Fernández");

		Set<Persona> equipo = new HashSet<Persona>();
		equipo.add(marta);
		equipo.add(pedro);

		Reunion r = new Reunion(LocalDateTime.now(), "Reunion con Personas");
		Reunion r1 = new Reunion(LocalDateTime.now(), "Otra reunion con Personas");
		rdao.save(r1);

		Set<Reunion> reunionesMarta = new HashSet<Reunion>();
		reunionesMarta.add(r);

		marta.setReuniones(reunionesMarta);

		Set<Reunion> reunionesPedro = new HashSet<Reunion>();
		reunionesPedro.add(r);
		reunionesPedro.add(r1);
		pedro.setReuniones(reunionesPedro);
		System.out.println(r);
		r.setParticipantes(equipo);
		rdao.save(r);
		System.out.println(r);

		ActaDao actaDao = new ActaDao();
		Acta a = new Acta("Reunion anulada", r);
		actaDao.save(a);
		// r.setActa(a);
		// rdao.update(r);

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
		/*
		 * Sala s = new Sala("S205","Sala grande",25); salaDao.save(s);
		 * System.out.println("Paso 1:"+salaDao.getAll());
		 * 
		 * s.setDescripcion("Sala Grande reformada"); salaDao.update(s);
		 * 
		 * System.out.println("Paso 2:"+salaDao.getAll());
		 * 
		 * Sala s2 = new Sala("99","Trastero",1); salaDao.save(s2);
		 * 
		 * System.out.println("Paso 3:"+salaDao.getAll());
		 * 
		 * salaDao.delete(s2);
		 * 
		 * System.out.println("Paso 4:"+salaDao.getAll());
		 * 
		 */

	}
}
