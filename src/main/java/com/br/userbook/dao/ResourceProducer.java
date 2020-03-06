package com.br.userbook.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class ResourceProducer {
	@PersistenceContext(unitName = "userbookdb")
	@Produces
	private EntityManager em;

}
