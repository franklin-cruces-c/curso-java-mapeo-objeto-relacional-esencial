package com.linkedin.learning.otrareunionmas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import com.linkedin.learning.otrareunionmas.dao.ReunionDao;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;

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
		System.out.println("Tu proxima reunion es " + rdao.proximaReunion());
	}
}
