package es.curso.controllers;

import java.util.ArrayList;

import es.curso.model.entity.Tarjeta;

public interface BuscarTarjetaPorNumeroController {
	public ArrayList<Tarjeta> searchByNumber(String numeroRecuperado);

}
