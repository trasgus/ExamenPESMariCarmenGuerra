package es.curso.controllersEjb;

import java.util.ArrayList;

import es.curso.controllers.BuscarTarjetasController;
import es.curso.model.entity.Tarjeta;
import es.curso.persistence.dao.TarjetaDao;
import es.curso.persistence.daoJdbc.TarjetaDaoJdbc;

public class BuscarTarjetasControllerEjb implements BuscarTarjetasController{

	public ArrayList<Tarjeta> mostrarRegistro(String numero4) {
		TarjetaDao tarjetaDao = new TarjetaDaoJdbc();
		
		return tarjetaDao.searchByNumber(numero4);
	}


	}


