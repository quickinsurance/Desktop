package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Health;
import entities.HealthQuotation;
import entities.User;
import services.interf.IQuotationInterfaceRemote;

@Stateless
@LocalBean
public class HealthQuotationServiceImlem implements IQuotationInterfaceRemote{
	@PersistenceContext(unitName = "Insurance-ejb")
	private EntityManager em;
	@Override
	public void addHealthQuotation(HealthQuotation healthQuotatin) {

		em.persist(healthQuotatin);
		System.out.println(healthQuotatin.toString());

		
	}
	@Override
	public List<HealthQuotation> getQuotations() {
		List<HealthQuotation> healths = em.createQuery("from HealthQuotation", HealthQuotation.class).getResultList();
		return healths;
	}
	@Override
	public List<HealthQuotation> getQuotationsByUser(User user) {
		System.out.println("fffffffff");

		javax.persistence.Query query = em.createQuery("select e from HealthQuotation e where e.User=:user", HealthQuotation.class);
        query.setParameter("user", user);
		System.out.println("fffffffff");
		@SuppressWarnings("unchecked")
		List<HealthQuotation> healthsQuotation = query.getResultList();
		return healthsQuotation;
	}

}
