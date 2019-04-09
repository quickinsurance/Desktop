package services.interf;

import java.util.List;

import javax.ejb.Remote;

import entities.VehicleQuotation;


@Remote
public interface VehicleQuotationServiceRemote {
	public int addVehicleQuotation(VehicleQuotation vQuotation); 
	public void removeVehicleQuotation(int id); 
	public void updateVehicleQuotation(VehicleQuotation vQuotation); 
	public VehicleQuotation findVehicleQuotationById(int id); 
	public List<VehicleQuotation> findAllVehicleQuotations();

}
