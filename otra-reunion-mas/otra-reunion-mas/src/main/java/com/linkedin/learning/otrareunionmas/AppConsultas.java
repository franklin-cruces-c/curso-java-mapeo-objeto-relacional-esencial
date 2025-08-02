package com.linkedin.learning.otrareunionmas;

import java.util.List;

import com.linkedin.learning.otrareunionmas.dao.SalaDao;
import com.linkedin.learning.otrareunionmas.dominio.Sala;

public class AppConsultas {

	public static void main(String[] args) {
		SalaDao salaDao = new SalaDao();
		List<Sala> salasPara4 = salaDao.findSalasParaN(4);
		System.out.println("Salas para 4:Mayor o igual que n" + salasPara4);

		List<Sala> salasPara3 = salaDao.findSalasParaN(3);
		System.out.println("Salas para 3(1 Criteria):Mayor o igual que n" + salasPara3);

		List<Sala> salasAdecuadasPara3 = salaDao.findSalasAdecuadasParaN(3);
		System.out.println("Salas adecuadas para 3 (Con predicates y 2 Criteria)desde n hasta el doble de n:"+salasAdecuadasPara3);

	}

}
