package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Client;
import entities.Contract;
import entities.Housing;
import entities.User;
import services.interf.IhousingServiceLocal;
import services.interf.IhousingServiceRemote;

@Stateless
public class HousingContractService implements IhousingServiceLocal, IhousingServiceRemote {
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	@Override
	public int addContracthouse(Housing cn) {
		System.out.println("In addUser : ");
		em.persist(cn);
		return cn.getContract_id();
	}

	@Override
	public void removeContracthouse(int id) {
		//Query query = em.createQuery("delete e from Housing e where e. ");
		em.remove(em.find(Housing.class, id));

	}

	@Override
	public void updateContracthouse(Housing newhousevalue) {
		System.out.println("In updateUser : ");
		Housing house = em.find(Housing.class, newhousevalue.getContract_id());
		house.setEtatdemande(newhousevalue.getEtatdemande());
		System.out.println("Out of updateUser : ");
	

	}

	@Override
	public Housing findContracthouseById(int id) {
	
		Housing houseC = em.find(Housing.class, id);

		System.out.println("Out of findContracthById : ");
		return houseC;
	}

	@Override
	public List<Housing> findAllContracthous() {
		System.out.println("In findAllUsers : ");
		System.out.println("Out of findAllnotdone: ");
		List<Housing> Contracth = em.createQuery("from Housing", Housing.class).getResultList();
		
		System.out.println("Out of findAllContracths+ : ");
		return Contracth;
	}
	public List<Housing> findHouseContractsbyclient(int id) {
		System.out.println("In findAllUsers : ");
		System.out.println("Out of findAllnotdone: ");
		Query q =em.createNativeQuery("SELECT * FROM housing a where a.Client_User_ID = :id");
		q.setParameter("id", id);
		List<Housing> Contracthouse =  q.getResultList();
		
		System.out.println("Out of findAllContracths+ : ");
		return Contracthouse;
		
	}

	@Override
	public int addclient(Client cl) {
		em.persist(cl);
		return cl.getId();
	}
	@Override

		public User getUserByCIN(int cin) {
			javax.persistence.Query query = em.createQuery("select e from User e where e.cin=:cin", User.class);
	        query.setParameter("cin", cin);
	       
	       @SuppressWarnings("unchecked")
		List<User>  list =  query.getResultList();
	        if (list.isEmpty()){
	        	return null;
	        }else{
	        return list.get(0);}
	   
		}
	
		
	}
	
	


