package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.Vehicle;

@Remote
public interface VehicleContractServiceRemote {
	public int addVehicleContract(Vehicle vehicle); 
	public void removeVehicleContract(int id); 
	public void updateVehicleContract(Vehicle vehicle); 
	public Vehicle findVehicleContractById(int id); 
	public List<Vehicle> findAllVehicleContracts();
	public List<String> getGroup();
}
