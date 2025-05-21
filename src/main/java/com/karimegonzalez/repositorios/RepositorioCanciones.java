package com.karimegonzalez.repositorios;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karimegonzalez.modelos.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long>{
	
	List<Cancion> findAll();
	
	Optional<Cancion> findById(Long id);
	
}
