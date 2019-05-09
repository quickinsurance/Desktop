package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Vehicle;
import services.interf.VehicleContractServiceRemote;

@Stateless
@LocalBean
public class VehicleContractServiceImpl implements VehicleContractServiceRemote {
	@PersistenceContext(unitName = "Insurance-ejb") 
	EntityManager em;
	@Override
	public int addVehicleContract(Vehicle vehicle) {
		System.out.println("In addVehicleContract : "); 
		em.persist(vehicle); 
		System.out.println("Out of addUser" + vehicle.getContract_id()); 
		return vehicle.getContract_id();
	}

	@Override
	public void removeVehicleContract(int id) {
		System.out.println("In removeVehicleContract : "); 
		em.remove(em.find(Vehicle.class, id)); 
		System.out.println("Out of removeVehicleContract : "); 		
	}

	@Override
	public void updateVehicleContract(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vehicle findVehicleContractById(int id) {
		System.out.println("In findVehicleContractById : "); 
		Vehicle vehicle = em.find(Vehicle.class, id); 
		System.out.println("Out of findVehicleContractById : "); 
		return vehicle;
	}
	

	@Override
	public List<Vehicle> findAllVehicleContracts() {
		System.out.println("In findAllvehicleContracts : "); 
		List<Vehicle> vehicle = em.createQuery("from Vehicle", Vehicle.class).getResultList(); 
		System.out.println("Out of findAllVehicleQuotations : "); 
		return vehicle; 
	}

}
