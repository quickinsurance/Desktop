package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Accident;
import entities.Agent;
import entities.Expert;
import services.interf.IAccidentInterfaceRemote;
@Stateless
public class AccidentServiceImplem implements IAccidentInterfaceRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;

	@Override
	public List<Accident> getListHousingAccident(Agent agent) {
		javax.persistence.Query query = em.createQuery("Select c From  Accident c join c.Housing co where co.Agent=:agent and c.treated=:treated", Accident.class);
		query.setParameter("agent", agent);
		query.setParameter("treated", false);
		@SuppressWarnings("unchecked")
		List<Accident> listAccidentHousing = query.getResultList();
		return listAccidentHousing;
	}

	@Override
	public List<Accident> getListVehicleAccident(Agent agent) {
		javax.persistence.Query query = em.createQuery("Select c From  Accident c join c.Vehicle co where co.Agent=:agent and c.treated=:treated", Accident.class);
		query.setParameter("agent", agent);
		query.setParameter("treated", false);
		@SuppressWarnings("unchecked")
		List<Accident> listAccidentVehicle = query.getResultList();
		return listAccidentVehicle;
	}

	@Override
	public List<Accident> getListHousingAccidentTreatedByExpert(Agent agent) {
		javax.persistence.Query query = em.createQuery("Select c From  Accident c join c.Housing co where co.Agent=:agent and c.expert_traited=:treated and c.sinister_traited=:sinister_traited", Accident.class);
		query.setParameter("agent", agent);
		query.setParameter("treated", true);
		query.setParameter("sinister_traited", false);
		@SuppressWarnings("unchecked")
		List<Accident> listAccidentHousing = query.getResultList();
		return listAccidentHousing;
	}

	@Override
	public List<Accident> getListAccidentNOtTreatedByExpert(Expert expert) {
		javax.persistence.Query query = em.createQuery("Select c From  Accident c where c.Expert=:expert and c.expert_traited=:treated", Accident.class);
		query.setParameter("expert", expert);
		query.setParameter("treated", false);
		@SuppressWarnings("unchecked")
		List<Accident> listAccident = query.getResultList();
		return listAccident;
	}

	@Override
	public List<Accident> getListVehicleAccidentTreatedByExpert(Agent agent) {
		javax.persistence.Query query = em.createQuery("Select c From  Accident c join c.Vehicle co where co.Agent=:agent and c.expert_traited=:treated and c.sinister_traited=:sinister_traited", Accident.class);
		query.setParameter("agent", agent);
		query.setParameter("treated", true);
		query.setParameter("sinister_traited", false);
		@SuppressWarnings("unchecked")
		List<Accident> listAccidentVehicle = query.getResultList();
		return listAccidentVehicle;
	}

	@Override
	public void updateAccidentAgent(Accident acident) {
	
		Accident accident = em.find(Accident.class, acident.getAccident_id());
		accident.setTreated(acident.isTreated());
		accident.setExpert(acident.getExpert());
	}

	@Override
	public void updateAccidentByexpert(Accident accident) {
		Accident accident2 = em.find(Accident.class, accident.getAccident_id());
		accident2.setExpert_opinion(accident.getExpert_opinion());
		accident2.setExpert_traited(accident.isExpert_traited());
		accident2.setExpert_refund(accident.getExpert_refund());
		
	}

	@Override
	public Accident getAccidentById(int IdAccident) {
		Accident accident = em.find(Accident.class, IdAccident);

		return accident;
	}

	@Override
	public void updateAccidentAfterAddSinister(Accident accident) {
		
		Accident accid = em.find(Accident.class, accident.getAccident_id());
		accid.setSinister_traited(accident.isSinister_traited());
	}

}
