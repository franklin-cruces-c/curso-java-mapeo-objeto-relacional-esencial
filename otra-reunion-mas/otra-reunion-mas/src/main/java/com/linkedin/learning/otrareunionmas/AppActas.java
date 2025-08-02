package com.linkedin.learning.otrareunionmas;

import java.util.List;

import com.linkedin.learning.otrareunionmas.dao.ActaDao;
import com.linkedin.learning.otrareunionmas.dominio.Acta;

public class AppActas {

	public static void main(String[] args) {

		ActaDao actaDao = new ActaDao();
		List<Acta> actasAntiguas = actaDao.findActasReunionesAntiguasQuery();
		System.out.println(actasAntiguas);

		List<Acta> actasAntiguasCriteria = actaDao.findActasReunionesAntiguasCriteria();
		System.out.println(actasAntiguasCriteria);

	}

}
