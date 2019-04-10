package services.interf;


import java.util.List;

import javax.ejb.Remote;

import entities.Agent;
import entities.Retreat;

@Remote
public interface IRetreatInterfaceRemote {
	
	public void addRetreat(Retreat retreat);
	public List<Retreat> listRetreatByagent(Agent agent);
	public List<Retreat> listRescissionRetreat(Agent agent);
	public List<Retreat> listReteat();
	public Retreat getRetreatByID(int idRetreat);
	

}
