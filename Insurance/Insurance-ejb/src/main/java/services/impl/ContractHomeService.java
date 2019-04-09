package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Client;
import entities.Contract;
import entities.Guarantee;
import entities.Housing;
import services.interf.IContracthomeServiceRemote;
import services.interf.IcontracthomeServiceLocal;




@Stateless
public class ContractHomeService implements IcontracthomeServiceLocal, IContracthomeServiceRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	

	@Override
	public int addContracth(Contract cn) {
em.persist(cn);
		return cn.getContract_id();
	}

	@Override
	public void removeContracth(int id) {
		em.remove(em.find(Contract.class, id));
		System.out.println("Out of removeContract: ");

	}

	@Override
	public void updateContracth(Contract cn) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contract findContractById(int id) {
		System.out.println("In findContracthById : ");
		Contract cth = em.find(Contract.class, id);

		System.out.println("Out of findContracthById : ");
		return cth;
	}

	@Override
	public List<Contract> findAllContracths() {
		System.out.println("In findAllUsers : ");
		System.out.println("Out of findAllnotdone: ");
		List<Contract> Contracth = em.createQuery("from Contract", Contract.class).getResultList();
		
		System.out.println("Out of findAllContracths+ : ");
		return Contracth;
	}

	@Override
	public List<Contract> findAllContractsbyclient(int id) {
		System.out.println("In findAllUsers : ");
		System.out.println("Out of findAllnotdone: ");
		Query q =em.createNativeQuery("SELECT * FROM contract a where a.Client_User_ID = :id");
		
		q.setParameter("id", id);
		List<Contract> Contracthouse =  q.getResultList();
		
		System.out.println("Out of findAllContracths+ : ");
		return Contracthouse;
	}


}
