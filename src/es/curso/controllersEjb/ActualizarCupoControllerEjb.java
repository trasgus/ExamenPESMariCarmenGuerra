package es.curso.controllersEjb;

import es.curso.controllers.ActualizarCupoController;
import es.curso.model.entity.Tarjeta;
import es.curso.persistence.dao.TarjetaDao;
import es.curso.persistence.daoJdbc.TarjetaDaoJdbc;

public class ActualizarCupoControllerEjb implements ActualizarCupoController{

	public void actualizar(Tarjeta tarjeta2) {
		TarjetaDao tarjetaDao = new TarjetaDaoJdbc();
		tarjetaDao.update(tarjeta2);
		
	}

}
