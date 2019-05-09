package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Agent;
import entities.Client;
import entities.Expert;
import entities.Financier;
import entities.User;
import services.interf.UserServiceRemote;

@Stateless
@LocalBean
public class UserServiceImpl implements UserServiceRemote {

	@PersistenceContext(unitName = "Insurance-ejb") 
	EntityManager em;

	@Override
	public int addUser(User user) {
		System.out.println("In addUser : "); 
		em.persist(user); 
		System.out.println("Out of addUser" + user.getId()); 
		return user.getId();

	}
	@Override
	public int addExpert(Expert expert) {
		em.persist(expert);
		return expert.getId();
	}
	@Override
	public int addFinancier(Financier financier) {
		em.persist(financier);
		return financier.getId();
	}

	@Override
	public int addAgent(Agent agent) {
		em.persist(agent);
		return agent.getId();
	}



	@Override
	public void removeUser(int id) {
		System.out.println("In removeUser : "); 
		em.remove(em.find(User.class, id)); 
		System.out.println("Out of removeUser : "); 

	}

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

	@Override
	public void removeFinancier(int id) {
		em.remove(em.find(Financier.class, id));
	}

	@Override
	public void removeExpert(int id) {
		em.remove(em.find(Expert.class, id));
	}


	@Override
	public void removeAgent(int id) {
		em.remove(em.find(Agent.class, id));
	}


	@Override
	public void updateUser(User userNewValues) {
		System.out.println("In updateUser : "); 
		User user1 = em.find(User.class, userNewValues.getId()); 
		user1.setEmail(userNewValues.getEmail()); 
		user1.setFirstName(userNewValues.getFirstName()); 
		user1.setLastName(userNewValues.getLastName()); 
		user1.setNote(userNewValues.getNote());
		user1.setCin(userNewValues.getCin());
		user1.setPhone(userNewValues.getPhone());
		System.out.println("Out of updateUser : "); 
	}
	@Override
	public void updateExpert(Expert expertNewValues) {
		Expert expert1 = em.find(Expert.class, expertNewValues.getId()); 
		expert1.setEmail(expertNewValues.getEmail()); 
		expert1.setFirstName(expertNewValues.getFirstName()); 
		expert1.setLastName(expertNewValues.getLastName()); 
		expert1.setPhone(expertNewValues.getPhone()); 
		expert1.setNote(expertNewValues.getNote());
		expert1.setPhoto(expertNewValues.getPhoto());
		expert1.setBirthDate(expertNewValues.getBirthDate());
		expert1.setCode(expertNewValues.getCode());
		expert1.setSpecialty(expertNewValues.getSpecialty());
	}
	@Override
	public void updateFinancier(Financier financierNewValues) {
		Financier financier1 = em.find(Financier.class, financierNewValues.getId()); 
		financier1.setEmail(financierNewValues.getEmail()); 
		financier1.setFirstName(financierNewValues.getFirstName()); 
		financier1.setLastName(financierNewValues.getLastName()); 
		financier1.setPhone(financierNewValues.getPhone()); 
		financier1.setNote(financierNewValues.getNote());
		financier1.setPhoto(financierNewValues.getPhoto());
		financier1.setBirthDate(financierNewValues.getBirthDate());
		financier1.setCode(financierNewValues.getCode());	
		financier1.setResponsability(financierNewValues.getResponsability());
		financier1.setService(financierNewValues.getService());
	}

	@Override
	public void updateAgent(Agent agentNewValues) {
		Agent agent1 = em.find(Agent.class, agentNewValues.getId()); 
		agent1.setEmail(agentNewValues.getEmail()); 
		agent1.setFirstName(agentNewValues.getFirstName()); 
		agent1.setLastName(agentNewValues.getLastName()); 
		agent1.setPhone(agentNewValues.getPhone()); 
		agent1.setNote(agentNewValues.getNote());
		agent1.setPhoto(agentNewValues.getPhoto());
		agent1.setBirthDate(agentNewValues.getBirthDate());
		agent1.setCode(agentNewValues.getCode());	
		agent1.setAssignment_date(agentNewValues.getAssignment_date());
		agent1.setAgence(agentNewValues.getAgence());
	}


	@Override
	public User findUserById(int id) {
		System.out.println("In findUserById : "); 
		User user = em.find(User.class, id); 
		System.out.println("Out of findUserById : "); 
		return user;

	}
	@Override
	public Expert findExpertById(int id) {
		Expert expert = em.find(Expert.class, id); 
		System.out.println("Out of findUserById : "); 
		return expert;
	}

	@Override
	public Financier findFinancierById(int id) {
		Financier financier = em.find(Financier.class, id); 
		System.out.println("Out of findUserById : "); 
		return financier;
	}
	@Override
	public Agent findAgentById(int id) {
		Agent agent = em.find(Agent.class, id); 
		System.out.println("Out of findUserById : "); 
		return agent;
	}


	@Override
	public List<User> findAllUsers() {
		System.out.println("In findAllUsers : "); 
		List<User> users = em.createQuery("from User", User.class).getResultList(); 
		System.out.println("Out of findAllUsers : "); 
		return users; 
	}

	@Override
	public List<Expert> findAllExperts() {
		System.out.println("In findAllUsers : "); 
		List<Expert> experts = em.createQuery("from Expert", Expert.class).getResultList(); 
		System.out.println("Out of findAllUsers : "); 
		return experts; 
	}

	@Override
	public List<Financier> findAllFinanciers() {
		System.out.println("In findAllUsers : "); 
		List<Financier> financiers = em.createQuery("from Financier", Financier.class).getResultList(); 
		System.out.println("Out of findAllUsers : "); 
		return financiers; 
	}

	@Override
	public List<Agent> findAllAgents() {
		System.out.println("In findAllUsers : "); 
		List<Agent> agents = em.createQuery("from Agent", Agent.class).getResultList(); 
		System.out.println("Out of findAllUsers : "); 
		return agents; 
	}
	@Override
	public int addClient(Client client) {
		em.persist(client);
		return client.getId();
	}
	@Override
	public Client findClientById(int id) {
		Client client = em.find(Client.class, id); 
		System.out.println("Out of findUserById : "); 
		return client;
	}
	@Override
	public List<Client> findAllClients() {
		System.out.println("In findAllUsers : "); 
		List<Client> clients = em.createQuery("from Client", Client.class).getResultList(); 
		System.out.println("Out of findAllUsers : "); 
		return clients; 
	}
	@Override
	public Client getClientByCIN(int cin) {
		javax.persistence.Query query = em.createQuery("select c from Client c where c.cin=:cin", Client.class);
		query.setParameter("cin", cin);

		@SuppressWarnings("unchecked")
		List<Client>  list =  query.getResultList();
		if (list.isEmpty()){
			return null;
		}else{
			return list.get(0);}
	}
	@Override
	public void removeUser(User user) {
		System.out.println("In removeUser : "); 
		em.remove(em.find(User.class, user)); 
		System.out.println("Out of removeUser : "); 		
	}
	@Override
	public User getUserByEmail(String email) {
		javax.persistence.Query query = em.createQuery("select u from User u where u.email=:email", User.class);
		query.setParameter("email", email);

		@SuppressWarnings("unchecked")
		List<Client>  list =  query.getResultList();
		if (list.isEmpty()){
			return null;
		}else{
			return list.get(0);}
	}
}
