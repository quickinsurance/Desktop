package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Client;
import services.interf.IClientInterfaceRemote;
@Stateless
public class ClientServiceImplem implements IClientInterfaceRemote {

	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	@Override
	public Client getClientByCin(int cin) {
		javax.persistence.Query query = em.createQuery("select e from Client e where e.cin=:cin", Client.class);
        query.setParameter("cin", cin);
       
       @SuppressWarnings("unchecked")
	List<Client>  list =  query.getResultList();
        if (list.isEmpty()){
        	return null;
        }else{
        return list.get(0);}
	}
	@Override
	public void addClient(Client client) {
		em.persist(client);
		System.out.println(client.toString());
		
	}

}
