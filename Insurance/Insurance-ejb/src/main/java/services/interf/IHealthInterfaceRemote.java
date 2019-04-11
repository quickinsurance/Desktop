package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.Agent;
import entities.Client;
import entities.Health;

@Remote
public interface IHealthInterfaceRemote {
public Health getHealthById(int idHealth);
public void addHealth(Health health);
public List<Health> listHealth();
public void updateHealth(Health health);
public void removeHealth(Health health);
public List<Health> getHealthByAgent(Agent agent);
public List<Health> getHealthByClient(Client client);
public List<Health> getRecissionByAgent(Agent agent);
}
