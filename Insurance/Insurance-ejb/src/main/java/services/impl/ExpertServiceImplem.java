package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Expert;
import services.interf.IExpertInterfaceRemote;
@Stateless
public class ExpertServiceImplem implements IExpertInterfaceRemote {

	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	@Override
	public List<Expert> getExpertBySpeciality(String speciality) {
		javax.persistence.Query query = em.createQuery("select e from Expert e where e.specialty=:specialty", Expert.class);
        query.setParameter("specialty", speciality);
		@SuppressWarnings("unchecked")
		List<Expert> experts = query.getResultList();
		return experts;
	}

}
