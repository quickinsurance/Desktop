package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Agent;
import entities.Retreat;
import services.interf.IRetreatInterfaceRemote;
@Stateless
public class RetreatServiceImplem implements IRetreatInterfaceRemote {

	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	@Override
	public void addRetreat(Retreat retreat) {
		em.persist(retreat);
		System.out.println(retreat.toString());

	}

	@Override
	public List<Retreat> listRetreatByagent(Agent agent) {
		System.out.println("fffffffff");

		javax.persistence.Query query = em.createQuery("select e from Retreat e where e.Agent=:agent and e.rescission=:res", Retreat.class);
        query.setParameter("agent", agent);
        boolean res = false;
        query.setParameter("res", res);
		System.out.println("fffffffff");
		@SuppressWarnings("unchecked")
		List<Retreat> retreats = query.getResultList();
		return retreats;
	}

	@Override
	public List<Retreat> listRescissionRetreat(Agent agent) {
		System.out.println("fffffffff");

		javax.persistence.Query query = em.createQuery("select e from Retreat e where e.Agent=:agent and e.rescission=:res", Retreat.class);
        query.setParameter("agent", agent);
        boolean res = true;
        query.setParameter("res", res);
		System.out.println("fffffffff");
		@SuppressWarnings("unchecked")
		List<Retreat> retreats = query.getResultList();
		return retreats;
	}

	@Override
	public List<Retreat> listReteat() {
		javax.persistence.Query query = em.createQuery("select e from Retreat e where e.rescission=:res", Retreat.class); 
        boolean res = false;
        query.setParameter("res", res);
		System.out.println("fffffffff");
		@SuppressWarnings("unchecked")
		List<Retreat> retreats = query.getResultList();
		return retreats;
	}

	@Override
	public Retreat getRetreatByID(int idRetreat) {
		Retreat retreat = em.find(Retreat.class, idRetreat);

		return retreat;
	}

}
