package com.linkedin.learning.otrareunionmas;

import java.util.List;

import com.linkedin.learning.otrareunionmas.dao.ActaDao;
import com.linkedin.learning.otrareunionmas.dominio.Acta;

public class AppActas {

	public static void main(String[] args) {

		ActaDao actaDao = new ActaDao();
		List<Acta> actasAntiguas = actaDao.findActasReunionesAntiguas();
		System.out.println(actasAntiguas);

	}

}
