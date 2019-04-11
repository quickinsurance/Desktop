package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Agent;
import entities.Client;
import entities.Health;
import services.interf.IHealthInterfaceRemote;

@Stateless
public class HealthServiceImplem implements IHealthInterfaceRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;

	@Override
	public void addHealth(Health health) {

		em.persist(health);
		System.out.println(health.toString());
	}

	@Override
	public void updateHealth(Health health) {
		Health h = em.find(Health.class, health.getContract_id());
		h.setCommission(health.getCommission());
		h.setPrime(health.getPrime());
		h.setDate_creation(health.getDate_creation());
		h.setDate_end(health.getDate_end());
		h.setMedicalFiles(health.getMedicalFiles());
		System.out.println(health.toString());
	}

	@Override
	public List<Health> listHealth() {
		System.out.println("fffffffff");

		List<Health> healths = em.createQuery("from Health", Health.class).getResultList();
		System.out.println("fffffffff");
		return healths;
	}

	@Override
	public void removeHealth(Health health) {
		em.remove(em.find(Health.class, health.getContract_id()));

	}

	@Override
	public Health getHealthById(int idHealth) {

		Health health = em.find(Health.class, idHealth);

		return health;
	}

	@Override
	public List<Health> getHealthByAgent(Agent agent) {
		System.out.println("fffffffff");

		javax.persistence.Query query = em.createQuery("select e from Health e where e.Agent=:agent and e.rescission=:res", Health.class);
        query.setParameter("agent", agent);
        boolean res = false;
        query.setParameter("res", res);
		System.out.println("fffffffff");
		@SuppressWarnings("unchecked")
		List<Health> healths = query.getResultList();
		return healths;
	}

	@Override
	public List<Health> getHealthByClient(Client client) {
		System.out.println("fffffffff");

		javax.persistence.Query query = em.createQuery("select e from Health e where e.Client=:client", Health.class);
        query.setParameter("client", client);
		System.out.println("fffffffff");
		@SuppressWarnings("unchecked")
		List<Health> healths = query.getResultList();
		return healths;
	}

	@Override
	public List<Health> getRecissionByAgent(Agent agent) {
		System.out.println("fffffffff");

		javax.persistence.Query query = em.createQuery("select e from Health e where e.Agent=:agent and e.rescission=:res", Health.class);
        query.setParameter("agent", agent);
        boolean res = true;
        query.setParameter("res", res);
		System.out.println("fffffffff");
		@SuppressWarnings("unchecked")
		List<Health> healths = query.getResultList();
		return healths;
	}

}
