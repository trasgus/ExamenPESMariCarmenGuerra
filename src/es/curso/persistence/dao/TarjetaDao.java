package es.curso.persistence.dao;

import java.util.ArrayList;

import es.curso.model.entity.Tarjeta;

public interface TarjetaDao {

	void create(Tarjeta tarjeta);

	ArrayList<Tarjeta> findAll();

	ArrayList<Tarjeta> searchByNumber(String number);

	void update(Tarjeta tarjeta);

}
