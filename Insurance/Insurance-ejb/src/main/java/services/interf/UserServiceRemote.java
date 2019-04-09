package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.Agent;
import entities.Client;
import entities.Expert;
import entities.Financier;
import entities.User;


@Remote
public interface UserServiceRemote {
	public int addUser(User user); 
	public void removeUser(int id); 
	public void removeUser(User user);
	public void updateUser(User user); 
	public User findUserById(int id); 
	public List<User> findAllUsers();
	public User getUserByCIN(int cin);
	public User getUserByEmail(String email);
	
	public int addExpert(Expert expert);
	public void removeExpert(int id);
	public void updateExpert(Expert expert);
	public Expert findExpertById(int id);
	public List<Expert> findAllExperts();
	
	public int addFinancier(Financier financier);
	public void removeFinancier(int id);
	public void updateFinancier(Financier financier);
	public Financier findFinancierById(int id);
	public List<Financier> findAllFinanciers();
	
	public int addAgent(Agent agent);
	public void removeAgent(int id);
	public void updateAgent(Agent agent);
	public Agent findAgentById(int id);
	public List<Agent> findAllAgents();
	
	public int addClient(Client client);
	public Client findClientById(int id);
	public List<Client> findAllClients();
	public Client getClientByCIN(int cin);


}
