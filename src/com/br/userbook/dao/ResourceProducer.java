package com.br.userbook.dao;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ResourceProducer {
	@PersistenceContext
	@Produces
	private EntityManager em;

}
