package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.VehicleQuotation;
import services.interf.VehicleQuotationServiceRemote;

@Stateless
public class VehicleQuotationServiceImpl implements VehicleQuotationServiceRemote {
	@PersistenceContext(unitName = "Insurance-ejb") 
	EntityManager em;

	@Override
	public int addVehicleQuotation(VehicleQuotation vQuotation) {
		System.out.println("In addUser : "); 
		em.persist(vQuotation); 
		System.out.println("Out of addUser" + vQuotation.getQuotation_id()); 
		return vQuotation.getQuotation_id();
	}

	@Override
	public void removeVehicleQuotation(int id) {
		System.out.println("In removeVehicleQuotation : "); 
		em.remove(em.find(VehicleQuotation.class, id)); 
		System.out.println("Out of removeVehicleQuotation : "); 
	}

	@Override
	public void updateVehicleQuotation(VehicleQuotation vQuotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VehicleQuotation findVehicleQuotationById(int id) {
		System.out.println("In findVehicleQuotationById : "); 
		VehicleQuotation vQuotation = em.find(VehicleQuotation.class, id); 
		System.out.println("Out of findVehicleQuotationById : "); 
		return vQuotation;
	}

	@Override
	public List<VehicleQuotation> findAllVehicleQuotations() {
		System.out.println("In findAllvehicleQuotations : "); 
		List<VehicleQuotation> vQuotations = em.createQuery("from VehicleQuotation", VehicleQuotation.class).getResultList(); 
		System.out.println("Out of findAllVehicleQuotations : "); 
		return vQuotations; 
	}

}
