package es.curso.controllersEjb;

import java.util.ArrayList;

import es.curso.controllers.DarAltaTarjetaController;
import es.curso.dispatchers.TarjetaCredito;
import es.curso.model.entity.Tarjeta;
import es.curso.persistence.dao.TarjetaDao;
import es.curso.persistence.daoEjb.TarjetaDaoJdbc;


public class DarAltaTarjetaControllerEjb implements DarAltaTarjetaController{

	private TarjetaDao tarjetaDao; //hago el import
	@Override
	public void agregar(Tarjeta tarjeta) {
		
	/* Aquí tendríamos que poner la lógica del negocio para agregar un cliente
		1. Verificar datos en Hacienda
		2. Agregarlo----> llamar a la capa DAO que es la que se encarga de dar de alta
		3. Enviar email al jefe de Obra
		4. Enviar un email al cliente.     */
		
		tarjetaDao = new TarjetaDaoJdbc(); //importo 
		tarjetaDao.create(tarjeta);
		
	
	}
	public ArrayList<Tarjeta> listarTarjetas() {
		// TODO Auto-generated method stub
		return null;
	}

}
