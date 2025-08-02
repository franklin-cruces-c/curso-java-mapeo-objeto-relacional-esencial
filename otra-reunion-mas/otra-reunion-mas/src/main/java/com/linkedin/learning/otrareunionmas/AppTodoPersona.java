package com.linkedin.learning.otrareunionmas;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.linkedin.learning.otrareunionmas.dominio.Acta;
import com.linkedin.learning.otrareunionmas.dominio.Persona;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;
import com.linkedin.learning.otrareunionmas.dominio.Sala;

public class AppTodoPersona {

	public static void main(String[] args) {

		PersonaDao personaDao = new PersonaDao();
		Optional<Persona> optPersona = personaDao.get(1);

		if (optPersona.isPresent()) {
			Persona p = optPersona.get();
//			System.out.println("Persona:" + p);

			// reuniones de la persona
			Set<Reunion> reuniones = p.getReuniones();
//			System.out.println("Reuniones:" + reuniones);

			Set<Sala> salas = new HashSet<Sala>();
			Set<Persona> participantes = new HashSet<Persona>();
			Set<Acta> actas = new HashSet<Acta>();

			for (Reunion reunion : reuniones) {
				salas.add(reunion.getSala());
				participantes.addAll(reunion.getParticipantes());
				actas.add(reunion.getActa());
			}
//			System.out.println("Salas:" + salas);
//			System.out.println("Participantes:" + participantes);
//			System.out.println("Actas:" + actas);
		}
	}

}
