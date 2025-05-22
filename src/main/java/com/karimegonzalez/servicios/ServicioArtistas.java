package com.karimegonzalez.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karimegonzalez.modelos.Artista;
import com.karimegonzalez.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
	
	@Autowired
	private final RepositorioArtistas repositorioArtistas;
	
	public ServicioArtistas(RepositorioArtistas repositorioArtistas) {
		this.repositorioArtistas= repositorioArtistas;
		
	}
	
	public List<Artista> obtenerTodosLosArtistas(){
		return this.repositorioArtistas.findAll();
	}
	
	public Artista obtenerArtistaPorId(Long idArtista) {
		return this.repositorioArtistas.findById(idArtista).orElse(null);
	}
	
	public Artista agregarArtista(Artista nuevoArtista) {
		return this.repositorioArtistas.save(nuevoArtista);
	}
	
}
