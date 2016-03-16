package com.unipe.barros.studio.orh.repositories;

import org.springframework.data.repository.CrudRepository;

import com.unipe.barros.studio.orh.models.Ferias;

public interface FeriasRepository extends CrudRepository<Ferias, Integer>{
	
//	@Query("select * from Ferias f, Usuario u where f.id = u.id ")
//	List<Ferias> findByFeriasIdAndUsuarioId(@Param("f.id") int idFerias, @Param("u.id") int idUsuario);
}
