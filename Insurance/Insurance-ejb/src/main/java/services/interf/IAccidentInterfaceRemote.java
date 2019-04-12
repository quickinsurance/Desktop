package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.Accident;
import entities.Agent;
import entities.Expert;
@Remote
public interface IAccidentInterfaceRemote {
	
	public List<Accident> getListHousingAccident(Agent agent);
	public List<Accident> getListVehicleAccident(Agent agent);
	public List<Accident> getListHousingAccidentTreatedByExpert(Agent agent);
	public List<Accident> getListAccidentNOtTreatedByExpert(Expert expert);
	public List<Accident> getListVehicleAccidentTreatedByExpert(Agent agent);
	public void updateAccidentAgent(Accident acident);
	public void updateAccidentByexpert(Accident accident);
	public Accident getAccidentById(int IdAccident);
	public void updateAccidentAfterAddSinister(Accident accident);
	
	
	
	
	

}
