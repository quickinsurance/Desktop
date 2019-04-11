package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Sinister;
import services.interf.ISinisterInterfaceRemote;
@Stateless
public class SinisterServiceImplem implements ISinisterInterfaceRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	@Override
	public void addSinister(Sinister sinister) {
		em.persist(sinister);

	}

}
