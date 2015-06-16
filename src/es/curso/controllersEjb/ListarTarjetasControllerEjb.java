package es.curso.controllersEjb;

import java.util.ArrayList;

import es.curso.controllers.ListarTarjetasController;
import es.curso.model.entity.Tarjeta;
import es.curso.persistence.daoJdbc.TarjetaDaoJdbc;

public class ListarTarjetasControllerEjb implements ListarTarjetasController{

	public ArrayList<Tarjeta> listarTodas() {
		TarjetaDaoJdbc daoTarjeta = new TarjetaDaoJdbc();
		ArrayList<Tarjeta> tarjetas = daoTarjeta.findAll();
		return tarjetas;
	}

}
