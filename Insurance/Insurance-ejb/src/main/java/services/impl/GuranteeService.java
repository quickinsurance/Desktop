package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Contract;
import entities.Guarantee;
import entities.Housing;
import entities.Sinister;
import services.interf.IgarantieServiceLocal;
import services.interf.IgarantieServiceRemote;



@Stateless
public class GuranteeService implements IgarantieServiceLocal, IgarantieServiceRemote {

	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	
	@Override
	public int addGuarantee(Guarantee gua) {
	em.persist(gua);
		return gua.getGuarantee_id();
	}

	@Override
	public void removeGuarantee(int id) {
		em.remove(em.find(Guarantee.class, id));

	}

	@Override
	public void updateGuarantee(Guarantee cn) {
		Guarantee emp = em.find(Guarantee.class, cn.getGuarantee_id()); 
		emp.setSinister(cn.getSinister());
		emp.setRefund(cn.getRefund());
		em.persist(emp);
		
	}

	@Override
	public Guarantee findGuaranteeById(int id) {
		Guarantee cth = em.find(Guarantee.class, id);

		System.out.println("Out of findContracthById : ");
		return cth;
		
	}

	@Override
	public List<Guarantee> findAllGurantees() {
		List<Guarantee> guaranteelist = em.createQuery("from Guarantee", Guarantee.class).getResultList();
		return guaranteelist;
	}



	@Override
	public List<Guarantee> findAllGuranteesbyclient(int id) {
		int id1 = 2;
		Query q  = em.createQuery("select o from Guarantee o where o.Contract.contract_id = :housing", Guarantee.class);
		List<Guarantee> guaranteelist = q.setParameter("housing",id1).getResultList();
		return guaranteelist;
	}

	@Override
	public List<Guarantee> findAllGuranteesbyContract(int id) {
		
		Query q  = em.createQuery("select o from Guarantee o where o.Contract.contract_id = :housing", Guarantee.class);
		List<Guarantee> guaranteelist = q.setParameter("housing",id).getResultList();
		return guaranteelist;

	}

	@Override
	public List<Guarantee> findAllGuranteesbyContractHousing() {
		Query q  = em.createQuery("select o from Guarantee o where o.Contract.type_contract = :housing", Guarantee.class);
		List<Guarantee> guaranteelist = q.setParameter("housing","housing").getResultList();
		return guaranteelist;
	}
	
	@Override
	public List<Sinister> findAllsinisters() {
		List<Sinister> guaranteelist = em.createQuery("from Sinister", Sinister.class).getResultList();
		return guaranteelist;
	}


	
	

}
