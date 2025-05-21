package com.karimegonzalez.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karimegonzalez.modelos.Cancion;
import com.karimegonzalez.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	private final RepositorioCanciones repositorioCanciones; //se anexa al constructor para que se pueda ocupar
	
	//inicializando en el constructor
	public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
		this.repositorioCanciones = repositorioCanciones;
	}
	
	//métodos
	public List<Cancion> obtenerTodasLasCanciones(){
		return this.repositorioCanciones.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long idCancion) {
		return this.repositorioCanciones.findById(idCancion).orElse(null);
	}
	
	public Cancion agregarCancion(Cancion nuevaCancion) {
		return this.repositorioCanciones.save(nuevaCancion);
	}
	
	public Cancion actualizaCancion(Cancion cancion) {
		return this.repositorioCanciones.save(cancion);
	}
	
}
