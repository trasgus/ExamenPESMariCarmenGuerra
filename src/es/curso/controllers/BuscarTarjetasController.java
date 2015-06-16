package es.curso.controllers;

import java.util.ArrayList;

import es.curso.model.entity.Tarjeta;

public interface BuscarTarjetasController {
	public ArrayList<Tarjeta> mostrarRegistro(String numero);

}
