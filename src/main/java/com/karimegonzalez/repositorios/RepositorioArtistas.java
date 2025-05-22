package com.karimegonzalez.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karimegonzalez.modelos.Artista;


@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long>{
	
	List<Artista> findAll();
	
	Optional<Artista> findById(Long id);
	
	Artista save(Artista nuevoArtista);
}
