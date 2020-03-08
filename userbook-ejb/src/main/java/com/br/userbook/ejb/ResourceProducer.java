package com.br.userbook.ejb;

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
