package es.curso.controllersEjb;

import java.util.ArrayList;

import es.curso.controllers.BuscarTarjetaPorNumeroController;
import es.curso.model.entity.Tarjeta;
import es.curso.persistence.dao.TarjetaDao;
import es.curso.persistence.daoJdbc.TarjetaDaoJdbc;

public class BuscarTarjetaPorNumeroControllerEjb implements BuscarTarjetaPorNumeroController{

	public ArrayList<Tarjeta> searchByNumber(String numeroRecuperado) {
	
			TarjetaDao tarjetaDao = new TarjetaDaoJdbc();
		
			return tarjetaDao.searchByNumber(numeroRecuperado);
		}


	}


