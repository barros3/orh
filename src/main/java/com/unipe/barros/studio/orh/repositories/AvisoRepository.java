package com.unipe.barros.studio.orh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unipe.barros.studio.orh.models.Aviso;

public interface AvisoRepository extends CrudRepository<Aviso, Integer>{

	@Query("select u from Aviso u where u.titulo = ?1")
	List<Aviso> findByTitulo(String titulo);
	
}