package com.unipe.barros.studio.orh.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.unipe.barros.studio.orh.jpaConsultas.PaginatorQueryHelper;
import com.unipe.barros.studio.orh.models.PaginatedList;
import com.unipe.barros.studio.orh.models.Usuario;

@Repository
public class PaginatedRepository {

	@PersistenceContext
	private EntityManager manager;

	public PaginatedList paginatedList(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Usuario.class, page, max);
	}

}
