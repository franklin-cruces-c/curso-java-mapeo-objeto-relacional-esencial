package com.linkedin.learning.otrareunionmas;

import com.linkedin.learning.otrareunionmas.dao.AbstractDao;
import com.linkedin.learning.otrareunionmas.dominio.Persona;

public class PersonaDao extends AbstractDao<Persona> {
	PersonaDao() {
		setClazz(Persona.class);
	}
}
