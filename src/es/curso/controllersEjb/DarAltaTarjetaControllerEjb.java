package es.curso.controllersEjb;

import java.util.ArrayList;

import es.curso.controllers.DarAltaTarjetaController;
import es.curso.model.entity.Tarjeta;
import es.curso.persistence.dao.TarjetaDao;
import es.curso.persistence.daoJdbc.TarjetaDaoJdbc;


public class DarAltaTarjetaControllerEjb implements DarAltaTarjetaController{

	private TarjetaDao tarjetaDao; //hago el import
	@Override
	public void agregar(Tarjeta tarjeta) {

		
		tarjetaDao = new TarjetaDaoJdbc(); //importo 
		tarjetaDao.create(tarjeta);
		
	
	}

	}




